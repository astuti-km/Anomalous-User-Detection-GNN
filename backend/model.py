import numpy as np
from sklearn.ensemble import RandomForestClassifier
import pickle   # ✅ ADD THIS

# Sample training data (ya tumhara original data)
X = np.array([[1,2,3,4], [5,6,7,8]])
y = np.array([0,1])

model = RandomForestClassifier()
model.fit(X, y)

# Save model
with open("model.pkl", "wb") as f:
    pickle.dump(model, f)

print("model.pkl created successfully ✅")