
//swap (array, j, j-1) vs swap (array, j-1, j)
//in for two tests 

//-1 5 3 2 4 8 7 => add that extra -1 
//should I swap or if I am over the limit 
//set to -1 
//set to minus infinity 
// saves one operation check in the for loop
//graphical package of the programming language
//insertion sort is good for best case scenario and for almost sorted arrays 

//selection sort is NOT stable

//B1 C1 B2 A1 A2 A3
//selection sort when I don't want to sort things : e.g list of 10000 find the first smallest three - run selection sort three times only
//this is not possible with merge or insertion sort 
//k best runners O(n*k) ~ O(n)

//it depends from case to case which algorithm to use 

//QUICK SORT : similar to Merge Sort 
//small no | large no 
//always divinde and put small numbers to left 
//what is small what is large?



//int [] array, min, max, View view)
// if(min == max)
//return
//int mid = partition (arry, min, max, view)
//mid!=max
 //   sort array , min, mid-1, view

 //if mid !- max 
 // sort array, mid +1, max, view

 //take first element as pivot tto group small/large elements
 // smaller or equal no than pivot | pivot | greater or equal no than pivot

//i - min
//j = max
//while(i!=j)
//while (array[j] > piv) {j--}
//while (array[i] <= piv && i < j ) {i++}
//swap (array, i, j);
//depends on what pivot you pick