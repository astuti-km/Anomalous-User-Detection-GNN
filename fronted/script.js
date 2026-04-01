document.querySelector("button").addEventListener("click", async () => {

    let input = document.querySelector("input").value;
    let data = input.split(",").map(Number);

    if(data.length !== 4){
    alert("⚠️ Please enter exactly 4 values (posts, followers, following, activity)");
    return;
}

    let response = await fetch("https://anomalous-user-detection-gnn.onrender.com/predict", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            data: data
        })
    });

    let result = await response.json();

    let popup = document.getElementById("popup");
    let text = document.getElementById("popupResult");
    let msg = document.getElementById("popupMsg");

    popup.style.display = "flex";

    if(result.result === "Anomalous"){
        text.innerText = "🚨 Result: Anomalous";
        text.style.color = "red";
        msg.innerText = "⚠️ Suspicious behavior detected!";
    } else {
        text.innerText = "🎉 Result: Normal";
        text.style.color = "lightgreen";
        msg.innerText = "✅ Congrats! User is safe.";

        confetti({
            particleCount: 100,
            spread: 70,
            origin: { y: 0.6 }
        });
    }
});

function closePopup(){
    document.getElementById("popup").style.display = "none";
}