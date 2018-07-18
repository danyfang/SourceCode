'''
How to save a neural network for future usage
'''
import tensorflow as tf

# first save it
'''
W = tf.Variable([[1,2,3],[1,2,3]], dtype = tf.float32, name = 'weights')
b = tf.Variable([[1,2,3]], dtype = tf.float32, name = 'biases')

init = tf.global_variables_initializer()
saver = tf.train.Saver()

with tf.Session() as sess:
    sess.run(init)
    save_path = saver.save(sess, 'my_net/save_net.ckpt')
    print('Save to path : ', save_path)
'''
# then fetch it
W = tf.Variable(tf.zeros([2,3]), dtype = tf.float32, name = 'weights')
b = tf.Variable(tf.zeros([1,3]), dtype = tf.float32, name = 'biases')

saver = tf.train.Saver()
with tf.Session() as sess:
    saver.restore(sess, './my_net/save_net.ckpt')
    print('weights : ', sess.run(W))
    print('biases: ', sess.run(b))
    # will print the exact result as saved in saving session
