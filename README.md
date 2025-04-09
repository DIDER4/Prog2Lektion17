### Opgave 1

I opgave02 pakken finder du en WeatherData klasse der kan generere tilfældig vejrdata.
Den kalder CurrentConditionsDisplay, StatisticsDisplay og ForecastDisplay klasserne.

Dette svarer til side 42 i bogen. 

a) Implementer de tre display klasser så det skriver vejrdata ud i konsollen, når update bliver kaldt.

CurrentConditionsDisplay skal vise temperatur, fugtighed og tryk.

StatisticsDisplay skal vise gennemsnit af temperatur, fugtighed og tryk.

ForecastDisplay skal vise en simpel vejrudsigt udregnet ud fra seneste og forrige temperatur, fugtighed og tryk.
Så hvis forrige temperatur var 20 grader og nu er den 25 grader, så er det en stigning på 5 grader og vi forudsiger at næste temperatur bliver 30 grader.

### Opgave 2

Vi må forvente at der kommer andrer måder at vise vejrdata på i fremtiden.
Hvilket designprincip overholder vi ikke med den nyværende implementation af WeatherData klassen? (Opgave 1)

Reimplementer opgave 1, men ved brug af Observer designmønstret.

I kan få hjælp fra bogen på side 58-59.

### Opgave 3

I denne opgave skal du implementerer en ObservableBag. En bag minder om et set, men med
den forskel, at det er tilladt at have dubletter. For hvert element der tilføjes bag’en, skal der
derfor holdes styr på hvor mange gange elementet forekommer i bag’en.

Du skal anvende et observer pattern til at gøre det muligt at observere på når der tilføjes og
fjernes elementer fra bag’en. 

I denne variant af observer pattern skal Observer både have at
vide hvilket element der tilføjes / fjernes, og dets aktuelle antal i ObservableBag efter
operationen er udført. 

Observeren skal blot printe oplysningerne.

Implementationen skal være baseret på et HashMap


    public interface Bag<E> {
        /** Add the element to the bag */
        public void add(E element);

        /** Remove the element from the bag (if it is the bag). */
        public void remove(E element);

        /** Get the count of the string s in the bag. */
        public int getCount(E element);
    }

<b>Ekstra opgave</b> Lav det der skal til, så din nye ObservableBag kan anvendes i et for-each loop. Elementer, der
er tilføjet flere gange til ObservableBag, skal kun optræde én gang i gennemløbet (antal
kommer ikke med i gennemløbet).

### Opgave 4

I denne opgave skal du simulere en boghandel. I models pakken finder du en Book klasse, en Customer klasse, en Salesman klasse (Der sælger bøger til kunderne) og en Buyer klasse (Der repræsenterer en indkøber der køber nye eksemplare af bøgerne).

Book klassen har tre attributter, bogen titel, hvor mange bøger der er på lager og en liste over hvilke kunder der har købt bogen. 

Customer klassen har en liste over de bøger den kunde har købt. 

a) opdatere makeSale metoden i Main klassen så de to lister i Book og Customer klassen bliver opdateret når en kunde køber en bog.

b) Brug observer designmønsteret, således at man kan blive notificeret når der sælges en bog. Så der skal laves et subject interface og et observer interface.

c) Implementer Buyer klassen som en observer, hvis antal kopier af en bog falder under 5, så skal den købe 10 nye bøger. Udskriv til konsollen hvilken bog der bliver indkøbt, det nye antal og af hvem.

d) Implementer Salesman klassen som en observer, hvis en kunde køber en bog, så skal der udskrives til konsollen hvilke andre bøger, kunder der har købt den pågældende bog, også har købt. Den udskrevne liste skal ikke indeholde dubletter.