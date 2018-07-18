import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt

def add_layer(inputs, in_size, out_size, act_func = None):
    with tf.name_scope('layer'):
        with tf.name_scope('weights'):
            Weights = tf.Variable(tf.random_normal([in_size, out_size]), name = 'W')
        with tf.name_scope('biases'):
            biases = tf.Variable(tf.zeros([1, out_size])+0.1, name = 'b')
        Wx_plus_b = tf.matmul(inputs, Weights) + biases
        if act_func is None:
            output = Wx_plus_b
        else:
            output = act_func(Wx_plus_b)
        return output

x_data = np.linspace(-1, 1, 300)[:, np.newaxis]
noise = np.random.normal(0, 0.05, x_data.shape)
y_data = np.square(x_data) - 0.5 + noise

#plt.scatter(x_data, y_data)
#plt.show()
with tf.name_scope('inputs'):
    xs = tf.placeholder(tf.float32, [None, 1], name = 'x_input')
    ys = tf.placeholder(tf.float32, [None, 1], name = 'y_input')

#add layers, one hidden layer and one output layer
l1 = add_layer(xs, 1, 10, act_func = tf.nn.relu)
prediction = add_layer(l1, 10, 1, act_func = None)

with tf.name_scope('loss'):
    loss = tf.reduce_mean(tf.reduce_sum(tf.square(ys-prediction), reduction_indices = [1]))

with tf.name_scope('train'):
    train = tf.train.GradientDescentOptimizer(0.1).minimize(loss)

init = tf.global_variables_initializer()

sess = tf.Session()

write = tf.summary.FileWriter('logss/', sess.graph)
sess.run(init)
#plot the real data, visualization
fig = plt.figure()
ax = fig.add_subplot(1,1,1)
ax.scatter(x_data, y_data)
plt.ion()
plt.show()

'''
for i in range(1000):
    sess.run(train, feed_dict = {xs : x_data, ys: y_data})
    if i % 50 == 0:
        try:
            ax.lines.remove(lines[0])
        except Exception:
            pass
        #print(sess.run(loss, feed_dict = {xs : x_data, ys: y_data}))
        prediction_value = sess.run(prediction, feed_dict = {xs : x_data})
        #plot the prediction_value
        lines = ax.plot(x_data, prediction_value, 'r', lw = 5)
        plt.pause(0.1)
'''
write.close()
