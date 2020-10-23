3. Znaleziony błąd w kodzie metody quicksort(double[] data) w klasie QuickSortIterative dotyczy dodawania
elementów do list starts oraz ends. W poprzedniej implementacji do tego celu używana była metoda add(E e), która
dodaje elementy na końcu listy, co uniemożliwiało późniejszy do nich dostęp za pomocą indeksu n. Metoda ta
została zastąpiona przez add(int index, E element), dodającą element na podanej pozycji.

7. W przypadku tablicy czas odczytu jest dużo krótszy niż przy zastosowaniu listy. Ponadto elementy nie są
dopisywane na końcu, lecz pod konkretnym indeksem (dla listy czas dodawania elementów na ostatniej pozycji jest
krótszy niż w przypadku tablicy). Wobec tego tablica wydaje się być bardziej optymalnym rozwiązaniem.
Z tego powodu w klasie QuickSortIterative postanowiłam zatąpić listy tablicami.