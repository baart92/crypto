#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main ()
{
  srand(1);
  int i;
  for(i = 1; i <= 10; i++)
  {
    printf("%d\n", rand());
  }
  return 0;
}
