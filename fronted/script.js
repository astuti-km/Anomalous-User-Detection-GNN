document.getElementById("analyzeBtn").addEventListener("click", async () => {

    let input = document.getElementById("inputData").value;
    let data = input.split(",").map(Number);

    if(data.length !== 4){
        alert("Enter 4 values");
        return;
    }

    try {
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
            msg.innerText = "✅ User is safe.";
        }

    } catch (error) {
        console.error("Error:", error);
        alert("Backend not responding");
    }
});