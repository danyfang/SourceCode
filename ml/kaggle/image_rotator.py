import os
import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt

IMAGE_SIZE = 256


def rotate_images(X_imgs):
    X_rotate = []
    tf.reset_default_graph()
    X = tf.placeholder(tf.float32, shape = (IMAGE_SIZE, IMAGE_SIZE, 1))
    k = tf.placeholder(tf.int32)
    tf_img = tf.image.rot90(X, k = k)
    with tf.Session() as sess:
        sess.run(tf.global_variables_initializer())
        for img in X_imgs:
            for i in range(3):  # Rotation at 90, 180 and 270 degrees
                rotated_img = sess.run(tf_img, feed_dict = {X: img, k: i + 1})
                X_rotate.append(rotated_img)
        
    X_rotate = np.array(X_rotate, dtype = np.float32)
    return X_rotate

def flip_images(X_imgs):
    X_flip = []
    tf.reset_default_graph()
    X = tf.placeholder(tf.float32, shape = (IMAGE_SIZE, IMAGE_SIZE, 1))
    tf_img1 = tf.image.flip_left_right(X) # Flip left and right
    tf_img2 = tf.image.flip_up_down(X) # Flip upside down
    tf_img3 = tf.image.transpose_image(X) # Transpose
    with tf.Session() as sess:
        sess.run(tf.global_variables_initializer())
        for img in X_imgs:
            flipped_imgs = sess.run([tf_img1, tf_img2, tf_img3], feed_dict = {X: img})
            X_flip.extend(flipped_imgs)
    X_flip = np.array(X_flip, dtype = np.float32)
    return X_flip
	

path = '/Users/xuqiang/Desktop/dida/labels/'
images = os.listdir(path)
X_imgs = []
for i in images:
    tmp = plt.imread(path+i)
    X_imgs.append(tmp)

rotated_images = rotate_images(X_imgs)
flipped_images = flip_images(X_imgs)



#rotated_imgs = rotate_images(X_imgs)
