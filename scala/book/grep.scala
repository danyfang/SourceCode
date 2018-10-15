
def grep(pattern : String) = {
    for{
        file <- filesHere
        if file.getName.endsWith(".scala")
        line <- fileLines(file)
        trimmed = line.trim
        if trimmed.matches(pattern)
    }println(file + ": " trimmed)
}
