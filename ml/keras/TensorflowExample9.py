import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt
from sklearn.datasets import load_sample_images

dataset = np.array(load_sample_images().images, dtype=np.float32)
batch_size, height, width, channels = dataset.shape

'''
filters_test = np.zeros(shape=(7,7, channels, 2), dtype=np.float32)
filters_test[:,3,:,0] = 1
filters_test[3,:,:,1] = 1

X = tf.placeholder(tf.float32, shape=(None, height, width, channels))
convolution = tf.nn.conv2d(X, filters_test, strides=[1,2,2,1], padding='SAME')

with tf.Session() as sess:
    output = sess.run(convolution, feed_dict={X : dataset})

plt.imshow(output[0,:,:,1])
plt.show()
'''

###another script to demonstrate pooling
X = tf.placeholder(tf.float32, shape=(None, height, width, channels))
max_pool = tf.nn.max_pool(X, ksize=[1,2,2,1], strides=[1,2,2,1], padding="VALID")

with tf.Session() as sess:
    output = sess.run(max_pool, feed_dict={X : dataset})

plt.imshow(output[0].astype(np.uint8))
plt.show()
