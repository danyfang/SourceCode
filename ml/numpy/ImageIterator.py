import os
import numpy as np
import matplotlib.pyplot as plt

                

class ImageIterator:
    '''
    An image iterator class, taken a list of paths containing images
    as inputs and produce a numpy array as output.
    Output patches are organized in following format:
    [#of patches, channels, height, width]
    where the number of patches are 30, channels are 3
    height and width are both 512
    
    when forever is set True, the output patches are strictly 20*3*512*512
    as the beginning patches will fill the gap if the last batch has size less than 30

    when forever is set False, the last batch of patches may have size less than 30


    @parameter: path_to_image
        the path to the folder where all images are stored
    @parameter : forever
        determine if patches are continously fed to the user 
    @parameter: random
        determine if tha images are randomly ordered within each batch of patches 

    Class written by Xuqiang Fang, Email: danyfang7@gmail.com
    '''
    def __init__(self, path_to_image, forever=True, random=True):
        self.path = path_to_image
        self.len = len(path_to_image)
        self.index = 0
        self.forever = forever
        self.random = random

    def __iter__(self):
        if self.forever:
            while True:
                ans = []
                for i in range(30):
                    image = plt.imread(self.path[self.index])
                    self.index += 1
                    self.index %= self.len
                    height, width, channels = image.shape

                    ## to get a random patch, just select the
                    ## upper left corner position randomly
                    a = np.random.randint(height-512)
                    b = np.random.randint(width-512)
                    slicing = image[a:a+512,b:b+512,:]
                    ans.append(slicing)

                ret = np.array(ans)
                ## if random order is required, shuffle the array
                if self.random:
                    np.random.shuffle(ret)
                ## swap axis to obtain desired output
                ret = np.swapaxes(ret, 2,3)
                ret = np.swapaxes(ret, 1,2)
                yield ret

        else:
            while self.index < len(self.path):
                ans = []
                for i in range(30):
                    try:
                        image = plt.imread(self.path[self.index])
                    except IndexError:
                        break
                    self.index += 1
                    height, width, channels = image.shape
                    ## to get a random patch, just select the
                    ## upper left corner position randomly
                    a = np.random.randint(height-512)
                    b = np.random.randint(width-512)
                    slicing = image[a:a+512,b:b+512,:]
                    ans.append(slicing)

                ret = np.array(ans)
                ## if random order is required, shuffle the array
                if self.random:
                    np.random.shuffle(ret)
                ## swap axis to obtain desired output
                ret = np.swapaxes(ret, 2,3)
                ret = np.swapaxes(ret, 1,2)
                yield ret


   
#### test program
def main():
    path = '/Users/xuqiang/Pictures/201602Home With Susie/'
    images = os.listdir(path)
    path_to_image = []
    for im in images:
        if im.endswith('.JPG'):
            path_to_image.append(path+im)
    
    print('# of images: ', len(path_to_image))
    s = ImageIterator(path_to_image, forever=True)
    it = iter(s)
    while True:
        try:
            print(next(it).shape)
        except StopIteration as e:
            print(e)
            break
        

if __name__ == '__main__':
    main()
            
            
        
        
