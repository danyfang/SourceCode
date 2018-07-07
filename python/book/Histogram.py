'''
import numpy as np
import matplotlib.pyplot as plt

mu, sigma = 2, 0.5
v = np.random.normal(mu, sigma, 10000)
plt.hist(v, bins = 50, normed = 1)
plt.show()

(n, bins) = np.histogram(v, bins=50, normed=True) 
plt.plot(.5*(bins[1:] + bins[:-1]), n)
plt.show()
'''

import tensorflow as tf
a = tf.constant(2)
b = tf.constant(3)
x = tf.add(a, b)
with tf.Session() as sess:
    writer = tf.summary.FileWriter('./graphs', sess.graph)
    print(sess.run(x))
writer.close
