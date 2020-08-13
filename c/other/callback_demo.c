/*
A callback function demo, ShowPercentage is a callback function that is 
passed as a pointer to another function, it will be automatically called 
at some point
*/

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>

#define DEFAULT_BLOCK_SIZE (4096)

typedef void (* CALLBACK) (int);

void ShowPercentage(int p)
{
  fprintf(stderr, "%dn%nn", p);
}

void CopyFile(const char *source, const char *target, CALLBACK callback)
{
  char buf[DEFAULT_BLOCK_SIZE];
  struct stat fs;
  int fdSrc, fdTrg;
  int readBytes = 0, totalReadBytes = 0, percentage = 0;
  fdSrc = open(source, O_RDONLY);
  fstat(fdSrc, &fs);
  fdTrg = open(target, O_CREAT|O_TURNC|O_RDWR);

  while((readBytes = read(fdSrc, buf, DEFAULT_BLOCK_SIZE)) > 0)
    {
      write(fdTrg, buf, readBytes);
      totalReadBytes += readBytes;
      callback((totalReadBytes*100)/fs.st_size);
    }

  close(fdTrg);
  close(fdSrc);
}

int main(void)
{
  CopyFile("A.TXT", "B.TXT", ShowPercentage);
  return 0;
} 

