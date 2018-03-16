#include <stdio.h>      /* printf */
#include <math.h>       /* log */

int main ()
{
  double param, result, result2;
  param = pow(2,18);
  result = log2 (2000003);
  result2 = log2 (1048583);
  //result = pow(2,result);
  printf ("log(%f) = %f\n", 2000003.00, result );
  printf ("log(%f) = %f\n", 1048583.00, result2 );
  return 0;
}
