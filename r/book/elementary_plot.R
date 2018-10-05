## Bar Plot
library(vcd)
true = TRUE
counts = table(Arthritis$Improved)
counts
par(mfrow=c(2,2))
barplot(counts, main='Simple Bar Plot', xlab='Improved', ylab='Frequency')
barplot(counts, main='Horizontal Bar Plot', xlab='Improved',
        ylab='Frequency', horiz=true)

counts = table(Arthritis$Improved, Arthritis$Treatment)
counts
barplot(counts, main='Stacked Bar Plot', xlab='Treatment', ylab='Frequency',
        col=c('red', 'yellow', 'green'), 
        legend=rownames(counts), beside = true)

## Pie Chart
library(plotrix)
par(mfrow=c(2,2))
slices=c(10,12,4,6,8)
labels1=c('England','China','Germany','Holland','USA')
pie(slices, labels=labels1, main='Simple Pie Chart', edges=300, radius = 1)
percentage=round(slices/sum(slices)*100)
labels2=paste(labels1, " ", percentage, "%", sep=" " )
pie(slices, labels=labels2, col=rainbow(length(labels2)),
    main='Pie Chart with Percentages', edges=300, radius=1)

pie3D(slices, labels=labels1, main="Simple 3D Pie Chart",
      explode=0.1, edges=300, radius=1)

## Dot Plot
par(mfrow=c(1,1))
dotchart(mtcars$mpg, cex=0.7, labels=row.names(mtcars),
         main='Gas Mileage for Car Models',
         xlab='Miles Per Galon')