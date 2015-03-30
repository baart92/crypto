#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main ()
{
  srand(1);
  int i;
  for(i = 1; i <= 343; i++)
  {
      rand();
  }
  for(i = 344; i <= 350; i++)
  {
      printf("%d\n", ((unsigned int)rand()));
  }
  return 0;
}
