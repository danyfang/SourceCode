# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.8

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/xuqiang/Source/cpp/dynamic

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/xuqiang/Source/cpp/dynamic/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/dynamic.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/dynamic.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/dynamic.dir/flags.make

CMakeFiles/dynamic.dir/dynamic.cpp.o: CMakeFiles/dynamic.dir/flags.make
CMakeFiles/dynamic.dir/dynamic.cpp.o: ../dynamic.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/xuqiang/Source/cpp/dynamic/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/dynamic.dir/dynamic.cpp.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/dynamic.dir/dynamic.cpp.o -c /Users/xuqiang/Source/cpp/dynamic/dynamic.cpp

CMakeFiles/dynamic.dir/dynamic.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/dynamic.dir/dynamic.cpp.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/xuqiang/Source/cpp/dynamic/dynamic.cpp > CMakeFiles/dynamic.dir/dynamic.cpp.i

CMakeFiles/dynamic.dir/dynamic.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/dynamic.dir/dynamic.cpp.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/xuqiang/Source/cpp/dynamic/dynamic.cpp -o CMakeFiles/dynamic.dir/dynamic.cpp.s

CMakeFiles/dynamic.dir/dynamic.cpp.o.requires:

.PHONY : CMakeFiles/dynamic.dir/dynamic.cpp.o.requires

CMakeFiles/dynamic.dir/dynamic.cpp.o.provides: CMakeFiles/dynamic.dir/dynamic.cpp.o.requires
	$(MAKE) -f CMakeFiles/dynamic.dir/build.make CMakeFiles/dynamic.dir/dynamic.cpp.o.provides.build
.PHONY : CMakeFiles/dynamic.dir/dynamic.cpp.o.provides

CMakeFiles/dynamic.dir/dynamic.cpp.o.provides.build: CMakeFiles/dynamic.dir/dynamic.cpp.o


# Object files for target dynamic
dynamic_OBJECTS = \
"CMakeFiles/dynamic.dir/dynamic.cpp.o"

# External object files for target dynamic
dynamic_EXTERNAL_OBJECTS =

dynamic: CMakeFiles/dynamic.dir/dynamic.cpp.o
dynamic: CMakeFiles/dynamic.dir/build.make
dynamic: CMakeFiles/dynamic.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/xuqiang/Source/cpp/dynamic/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable dynamic"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/dynamic.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/dynamic.dir/build: dynamic

.PHONY : CMakeFiles/dynamic.dir/build

CMakeFiles/dynamic.dir/requires: CMakeFiles/dynamic.dir/dynamic.cpp.o.requires

.PHONY : CMakeFiles/dynamic.dir/requires

CMakeFiles/dynamic.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/dynamic.dir/cmake_clean.cmake
.PHONY : CMakeFiles/dynamic.dir/clean

CMakeFiles/dynamic.dir/depend:
	cd /Users/xuqiang/Source/cpp/dynamic/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/xuqiang/Source/cpp/dynamic /Users/xuqiang/Source/cpp/dynamic /Users/xuqiang/Source/cpp/dynamic/cmake-build-debug /Users/xuqiang/Source/cpp/dynamic/cmake-build-debug /Users/xuqiang/Source/cpp/dynamic/cmake-build-debug/CMakeFiles/dynamic.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/dynamic.dir/depend

