from flask import Flask, request, jsonify
from model import predict_user
from flask_cors import CORS


app = Flask(__name__)
CORS(app)
@app.route('/predict', methods=['POST'])
def predict():
    data = request.json
    result = predict_user(data)
    return jsonify({"result": result})

if __name__ == '__main__':
    app.run(debug=True)