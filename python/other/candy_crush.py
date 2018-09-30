'''
a candy crush app
'''

from turtle import *
import tkinter as tk

root = tk.Tk()
class Application(tk.Frame):
    def __init__(self, master=None):
        super().__init__(master)
        self.pack()
        self.create_widgets()

    def create_widgets(self):
        self.hi_there = tk.Button(self)
        self.hi_there["text"] = "Hello World\n(click me)"
        self.hi_there["command"] = self.say_hi
        self.hi_there.pack(side="top")

        self.quit = tk.Button(self, text="QUIT", fg="red",
                              command=root.destroy)
        self.quit.pack(side="bottom")

    def say_hi(self):
        print("hi there, everyone!")



class candy_crush:
    def candy(self, grid):
        r, c = len(grid), len(grid[0])
        changed = True
        while changed:
            changed = False

            for i in range(r):
                for j in range(c-2):
                    if abs(grid[i][j]) == abs(grid[i][j+1]) == abs(grid[i][j+2]) != 0:
                        grid[i][j] = grid[i][j+1] = grid[i][j+2] = -abs(grid[i][j])
                        changed = True

            for j in range(c):
                for i in range(r-2):
                    if abs(grid[i][j]) == abs(grid[i+1][j]) == abs(grid[i+2][j]) != 0:
                        grid[i][j] = grid[i+1][j] = grid[i+2][j] = -abs(grid[i][j])
                        changed = True

            for j in range(c):
                x = r-1
                for i in reversed(range(r)):
                    if grid[i][j] > 0:
                        grid[x][j] = grid[i][j]
                        x -= 1
                for i in reversed(range(x+1)):
                    grid[i][j] = 0
            p(grid)

        return grid

def p(g):
    for r in g:
        print(r)

def main():
    s = candy_crush()
    grid = [[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],
        [410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,4101,512,713,1014]]
    p(grid)
    p(s.candy(grid))
    grid = [[1,1,1],[3,1,2],[3,4,2]]
    p(grid)
    p(s.candy(grid))
    '''
    color('red', 'yellow')
    begin_fill()
    while True:
        forward(200)
        left(170)
        if abs(pos()) < 1:
            break
    end_fill()
    done()
    '''
    app = Application(master=root)
    app.mainloop()

if __name__ == '__main__':
    main()
    
