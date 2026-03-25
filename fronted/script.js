async function analyze() {
  const input = document.querySelector("input").value;

  if (!input) {
    alert("Please enter data");
    return;
  }

  const features = input.split(",").map(Number);

  try {
    // Wake up backend first
    await fetch("https://anomalous-backend.onrender.com");

    // Wait a bit
    await new Promise(res => setTimeout(res, 3000));

    const response = await fetch("https://anomalous-backend.onrender.com/predict", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ features: features })
    });

    const data = await response.json();

    localStorage.setItem("prediction", data.result);
    window.location.href = "result.html";

  } catch (error) {
    alert("Server is waking up... please try again in 5 seconds");
  }
}