/** Header file for InversionsCount.
 * 
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.07.05
 * @version     1.0
 * @link        GitHub    https://github.com/z3ppelin/InversionsCount
 * @licence     The MIT License (http://opensource.org/licenses/MIT); see LICENCE.txt
 */

#ifndef _INVERSIONS_COUNT_H_
#define _INVERSIONS_COUNT_H_

/* function prototypes */
int* merge(const int, const int, const int*, const int*, long long*);
int* mergeSort(const int, int*, long long*);
void err(const char*);
int readVectorFromFile(int**, int*, char*, char*);
void printVector(const int*, const int);

#endif /* _INVERSIONS_COUNT_H_ */
