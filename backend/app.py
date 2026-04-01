from flask import Flask, request, jsonify
from model import predict_user
from flask_cors import CORS
import os

app = Flask(__name__)
CORS(app)

@app.route('/predict', methods=['POST'])
def predict():
    try:
        data = request.json.get("data")
        
        if not data or len(data) != 4:
            return jsonify({"error": "Invalid input"}), 400

        result = predict_user(data)
        return jsonify({"result": result})

    except Exception as e:
        return jsonify({"error": str(e)}), 500