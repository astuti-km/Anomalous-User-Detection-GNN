def predict_user(features):
    posts, followers, following, activity = features

    if followers < 10 and activity < 0.2:
        return "Anomalous"
    else:
        return "Normal"