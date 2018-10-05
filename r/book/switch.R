## Learning R, syntax

feelings = c('happy', 'sad', 'angry', 'down')

for(f in feelings){
  print(
    switch(f, happy='I am very happy',
              sad='I am very sad',
              angry='I am angry',
              down='I am down',
              good='I am feeling good'
    )
  )
}

# define a function
fun = function(x, a, b, c){
  return(a*sin(x)^2 +b*x +c)
}
curve(fun(x, 20, 3, 4), xlim=c(1,20))
title('A strange function')
