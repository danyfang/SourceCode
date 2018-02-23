puts "Hello World!"
cities  = %w[ London
              Oslo
              Paris
	      Shanghai
              Beijing
	      Stockholm
              Amsterdam
              Berlin ]
visited = %w[Berlin Oslo]

puts "I still need " +
     "to visit the " +
     "following cities:",
     cities - visited
