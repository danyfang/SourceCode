import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.metrics import mean_squared_error
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.linear_model import LinearRegression

def plot_learning_curve(model, X, y):
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2)
    train_error = []; test_error = []
    for m in range(1, len(X_train)):
        model.fit(X_train[:m], y_train[:m])
        y_train_pred = model.predict(X_train[:m])
        y_test_pred = model.predict(X_test)
        train_error.append(mean_squared_error(y_train_pred, y_train[:m]))
        test_error.append(mean_squared_error(y_test_pred, y_test))
    plt.plot(np.sqrt(train_error), 'r-+', linewidth=2, label='train')
    plt.plot(np.sqrt(test_error), 'b-', linewidth=3, label='test')
    plt.show()

m = 100
X = 6*np.random.rand(m,1)-3
y = 0.5 * X**2 + X + 2 + np.random.randn(m,1)
clf = LinearRegression()
plot_learning_curve(clf, X, y)
