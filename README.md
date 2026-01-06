# Programowanie-Funkcyjne - Wojciech Kotulski

**Zadanie 1** Cask

:white_check_mark: 3.0 Zaimplementuj funkcję isSorted, która sprawdza czy dana funkcja jest posortowana zgodnie z podaną funkcją porównawczą [Link do commita 1](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/f6e718ee631c5fc9931e4163ed07cadca8e036ac) [Link do commita 2](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/7abcaa40edfd092b7f0a01b1a74954f9808501d2)

:white_check_mark: 3.5 Zaimplementuj funkcję, która zsumuje liczby po wierszach z trzech list na wejściu; wykorzystaj funkcję sprowadzi funkcję z trzema argumentami, do funkcji z dwoma [Link do commita 3](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/aef31676ce0ceb29ef2cd773b57b9246ed46fe27)

:white_check_mark: 4.0 Zaimplementuj funkcję setHead, która doda element na początku listy [Link do commita 4](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/4350c73666b62fa69c9bcd636a250e420cc644e6)

:white_check_mark: 4.5 Zaimplementuj funkcję append, która doda element we wskazanym miejscu w liście [Link do commita 5](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/7e87801134eea6572d3e6d52eded080b9367993e)

:white_check_mark: 5.0 Zaimplementuj funkcję, która policzy kwadrat liczb z dwóch list (po wierszach) za pomocą funkcji map oraz funkcji anonimowej [Link do commita 6](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/41b02d8715fd3aaf506b83f92d8e74bdf418d9b9)


Kod: [Link do zadania 1](https://github.com/K0stkarz/Programowanie-Funkcyjne/blob/main/Zadanie%201/app/src/Zadanie_1.scala)

https://github.com/user-attachments/assets/9363231c-59cf-4842-b1d6-948237abc9b5


**Zadanie 2** Dockerfile

:white_check_mark: Stwórz obraz dockerowy, który bazuje na najnowszej wersji Ubuntu LTS
oraz który zawiera paczki:
- Java 8
- Python 3
- Scala (dowolna wersja)
- sbt
- vim
  
[Link do commita](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/2d0c9996ca202e1adc7b687dfcd260d38d126413) [Link do dockerhuba](https://hub.docker.com/repository/docker/kostkarz/funkcyjne/tags/latest/sha256:cdb206a249b08487823d5dbd18842e65133d24443bc5fa1f8eb7af47bfbf0e92)

Kod: [Link do zadania 2](https://github.com/K0stkarz/Programowanie-Funkcyjne/blob/main/Zadanie%202/Dockerfile) 

https://github.com/user-attachments/assets/b52bc61b-b3cc-401e-b93b-88d977e36bc1


**Zadanie 3** Struktury danych

:white_check_mark: 3.0 zwrócą wynik funkcji tail, która usuwa pierwszy element z listy (parameter); należy rozważyć przypadek Nil jako parametr [Link do commita 1](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/8e70be282c8172a8493403c9937bf9cc346ac052)

:white_check_mark: 3.5 zwróci wynik funkcji drop, która usuwa n elementów z listy dwukierunkowej [Link do commita 2](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/5d6c2e4ddb24359e2fa098ee8a7e4eb876d9fbca)

:white_check_mark: 4.0 zwróci wynik funkcji dropWhile, która usuwa n elementów z listy dwukierunkowej, które spełniają warunek funkcji (parametr); należy wykorzystać podejście pattern match [Link do commita 3](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/59d9e81e23443ba37b36588d4d0a60f3dd1d8fdd)

:x: 4.5 zwróci wynik funkcji foldLeft wykorzystując do tego companion object

:x: 5.0 zwróci wynik funkcji concatenate na dwóch listach (parametry), która zwraca jedną listę

Kod: [Link do zadania 3](https://github.com/K0stkarz/Programowanie-Funkcyjne/tree/main/Zadanie%203/app/src)

https://github.com/user-attachments/assets/574182cd-8831-4d45-b996-931b51173260


**Zadanie 4** Typ opcjonalny

:white_check_mark: 3.0 zwróci taki sam wynik jak zad.1 4.5 ale wykorzysta typ opcjonalny [Link do commita 1](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/8e94905b425221ba79ef6234cd1b07afcd242846)

:white_check_mark: 3.5 zwroci wariancję z listy; do implementacji wykorzystać należy typ opcjonalny [Link do commita 2](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/84e093f6e806a595304f50626250af8216c9c6eb)

:white_check_mark: 4.0 zwróci listę (option), która jest wynikiem połączenia dwóch list (option); w przypadku gdy jedna z list jest None, funkcja powinna zwrócić None [Link do commita 3](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/965d4d585be8cef18096d027d93024d88abc1c01)

:x: 4.5 zwróci listę za pomocą metody mojeMap[A,B,C](a: Option[A], b: Option[B])(f:(A,B)=>C):Option[C]; należy wykorzystać metodę flatMap oraz map

:x: 5.0 zwróci taki średnią (mean) z listy zwracając Either

Kod: [Link do zadania 4](https://github.com/K0stkarz/Programowanie-Funkcyjne/tree/main/Zadanie%204/app/src)

https://github.com/user-attachments/assets/19646b99-260b-4864-974b-0e42b02a9245

**Zadanie 5** MapReduce

:white_check_mark: 3.0 zwróci słownik z liczbą powtarzających się liczb za pomocą funkcji mapreduce dla list z liczbami [Link do commita 1](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/3005304b1673df7efae05a810648c610539addb4)

:white_check_mark: 3.5 zwróci słownik z liczbami podniesionymi do sześcianu za pomocą funkcji mapreduce dla list z liczbami [Link do commita 2](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/dce57e3bc82c00e894c34d6202691a71358b996f)

:white_check_mark: 4.0  zwróci słownik (student, godziny nauki), która wykorzysta funkcją mapreduce oraz groupBy dla słownika na wejściu [Link do commita 3](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/7f6f18c26bebfcd916c5a71ba1c57bd831cd410d)

:x: 4.5 zwróci słownik (zdanie, wektor), która wykorzysta funkcję mapreduce oraz bagOfWords

:x: 5.0 zwróci słownik (student, średnia ocen), która wykorzysta funkcję mapreduce oraz join; na wejściu  są dwie listy: (numer_indeksu, student), (numer_indeksu, kurs, ocena)

Kod: [Link do zadania 5](https://github.com/K0stkarz/Programowanie-Funkcyjne/tree/main/Zadanie%205/app/src)


https://github.com/user-attachments/assets/64d5463d-d2db-46db-9f49-a54b6bf8bb09


**Zadanie 6** Scotty

:white_check_mark: 3.0 Zaimplementuj funkcję isSorted, która sprawdza czy dana funkcja jest posortowana zgodnie z podaną funkcją porównawczą [Link do commita 1](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/dd1838733e3e7cd32bfd45dab03a0fde2ffcd278)

:white_check_mark: 3.5 Zaimplementuj funkcję, która zsumuje liczby po wierszach z trzech list na wejściu; wykorzystaj funkcję sprowadzi funkcję z trzema argumentami, do funkcji z dwoma [Link do commita 2](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/17737288d59941b28bbf7aecf9c0de921cceac53)

:white_check_mark: 4.0 Zaimplementuj funkcję setHead, która doda element na początku listy [Link do commita 3](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/1c1f14e3618de0f08631a2dce8805ec104666606)

:white_check_mark: 4.5 Zaimplementuj funkcję append, która doda element we wskazanym miejscu w liście [Link do commita 4](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/6888237e06c5a1082aa9df8d6379e62b6c6bd364)

:white_check_mark: 5.0 Zaimplementuj funkcję, która policzy kwadrat liczb z dwóch list (po wierszach) za pomocą funkcji map oraz funkcji anonimowej [Link do commita 5](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/474a08ca52896dad8dc5fdbea22368f8e554b491)

Kod: [Link do zadania 6](https://github.com/K0stkarz/Programowanie-Funkcyjne/tree/main/Zadanie%206/app)


https://github.com/user-attachments/assets/37e6c7b6-4411-4b94-85a9-9d4061cbd143


**Zadanie 7** Maszyna stanów

:white_check_mark: 3.0 zwróci wartość między 0, a maxvalue of Int włącznie [Link do commita 1](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/90208826beba236381ec62a009292b19c2c22115)

:white_check_mark: 3.5 zwróci wartość między 0, a 1 (Double) z wyłączeniem 1 [Link do commita 2](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/73c90baa2f4a6ca4b49687bd475e399560900e4c)

:white_check_mark: 4.0 zwróci pary (Int, Double), (Double, Int) oraz krotki (Double,
Double, Double) wykorzystując funkcje z ocen 3.0 oraz 3.5 [Link do commita 3](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/c45eba55c00ec1ca42f65426855a9093dbeaa86d)

:x: 4.5 zwróci wartość jak w funkcji 3.5, ale wykorzysta map

:x: 5.0 zwróci wartość jak w funkcji 3.5, ale wykorzysta flatMap 

Kod: [Link do zadania 7](https://github.com/K0stkarz/Programowanie-Funkcyjne/tree/main/Zadanie%207/app)


https://github.com/user-attachments/assets/471f80dc-2618-4f1a-86f7-a1b41e07a5d6


**Zadanie 8** Monoidy, monady, funktory

:white_check_mark: 3.0 wykorzysta metodę map fuktora do wykonania funkcji dodawania lub odejmowania na dwóch wartość przyjętych na wejściu [Link do commita 1](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/6695d805375df44548ee8c32d9a80456da846443)

:x: 3.5 zwróci wartość konkatenacji trzech list za pomocą monoidy

:x: 4.0 zwróci wartość sumy listy liczb lub zwróci nil; zaimplementuj wykorzystując monady

:x: 4.5 zwróci zadanie z zestawy 6 na ocenę 4.0 i wykorzysta metodę combine oraz join

:x: 5.0 zwróci dla listy minimum 3 elementów typu int mapę: liczba elementów, suma,  wartość minimalna, wartość maksymalna; wykorzysta do tego monadę oraz metodę foldMap

Kod: [Link do zadania 8](https://github.com/K0stkarz/Programowanie-Funkcyjne/tree/main/Zadanie%208/app)

**Zadanie 9** Wątki

:white_check_mark: 3.0 zwróci wartość binarną czy podana na wejściu liczba jest liczbą pierwszą; wykorzysta Promise [Link do commita 1](https://github.com/K0stkarz/Programowanie-Funkcyjne/commit/a5b266cefb1de9de9e5e622a0c4aa4d50cc6f7c8)

:x: 3.5  zwróci posortowaną listę; wykorzysta Promise

:x: 4.0 zwróci wynik funkcji z zad. 5 na 4.0 (mapreduce); wykorzysta worker_threads

:x: 4.5  zwróci wynik bagOfWords dla danego tekstu na wejściu; stworzy pulę workterów

:x: 5.0 zwróci wynik funkcji z zad. 5 na 4.5; wykorzysta Promise.all oraz funkcję map

Kod: [Link do zadania 9](https://github.com/K0stkarz/Programowanie-Funkcyjne/tree/main/Zadanie%209)