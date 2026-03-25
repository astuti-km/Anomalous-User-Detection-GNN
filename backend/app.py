from flask import Flask, request, jsonify
from flask_cors import CORS
import numpy as np
import pickle

app = Flask(__name__)

# ✅ IMPORTANT: Enable CORS for all devices (GitHub Pages, mobile, etc.)
CORS(app, resources={r"/*": {"origins": "*"}})

# ✅ Load your trained model
with open("model.pkl", "rb") as f:
    model = pickle.load(f)

# ✅ Home route (for testing)
@app.route("/")
def home():
    return "Backend is running successfully 🚀"

# ✅ Prediction API
@app.route("/predict", methods=["POST"])
def predict():
    try:
        data = request.get_json()

        # Get features from frontend
        features = data.get("features")

        if not features:
            return jsonify({"error": "No input data provided"}), 400

        # Convert to numpy array
        features = np.array(features).reshape(1, -1)

        # Predict
        prediction = model.predict(features)[0]

        # Convert output
        if prediction == 1:
            result = "Anomalous User"
        else:
            result = "Normal User"

        return jsonify({"result": result})

    except Exception as e:
        return jsonify({"error": str(e)}), 500


# ✅ Run app
if __name__ == "__main__":
    app.run(host="0.0.0.0", port=10000)