# travel-go



\# Travel Booking System



\## Deskripsi



Travel Booking System adalah aplikasi berbasis console yang dikembangkan menggunakan Java untuk mensimulasikan proses pemesanan perjalanan seperti pada platform Traveloka atau Tiket.com.



Aplikasi ini memungkinkan pengguna untuk:



\- Mencari penerbangan

\- Memesan penerbangan

\- Mencari hotel

\- Memesan hotel

\- Membatalkan reservasi

\- Melihat seluruh reservasi yang telah dibuat



Proyek ini dibuat untuk memenuhi tugas mata kuliah Pemrograman Berorientasi Objek (Object-Oriented Programming) dengan menerapkan konsep OOP dan fitur Java 17.



\---



\## Anggota Kelompok



| Nama                         | NIM        |

|------------------------------|------------|

| NAJIB FAQIH FATHAN           | 2802669664 |

| LUNA ZHAFIRA                 | 2802687521 |

| HAGY PRIYO PRASETYO          | 2802669696 |

| DIANA PRAMESNANDHA           | 2802615390 |

| MICHAEL BASTIANO BAHA TLUPUN | 2602239812 |





\---



\## Fitur Utama



\### 1. Search Flight

Pengguna dapat mencari penerbangan berdasarkan:



\- Kota asal

\- Kota tujuan

\- Tanggal perjalanan



Sistem akan menampilkan daftar penerbangan yang sesuai.



\### 2. Book Flight

Pengguna dapat memilih penerbangan dan memasukkan data penumpang.



Sistem akan:



\- Membuat reservasi

\- Menghasilkan nomor konfirmasi unik

\- Mengurangi jumlah kursi tersedia



\### 3. Search Hotel

Pengguna dapat mencari hotel berdasarkan lokasi.



Sistem akan menampilkan daftar hotel yang tersedia.



\### 4. Book Hotel

Pengguna dapat memilih hotel dan memasukkan data tamu.



Sistem akan membuat reservasi hotel dengan nomor konfirmasi unik.



\### 5. Cancel Reservation

Pengguna dapat membatalkan reservasi menggunakan nomor konfirmasi.



\### 6. View Reservation

Menampilkan seluruh reservasi yang tersimpan dalam sistem.



\---



\## Struktur Project



```text

travelbooking/



├── TravelGoApplication.java

│

├── services/

│   └── TravelBookingSystem.java

│

├── entities/

│   ├── Flight.java

│   ├── Hotel.java

│   ├── Reservation.java

│   ├── FlightReservation.java

│   └── HotelReservation.java

│

├── interfaces/

│   └── Bookable.java

│

├── exceptions/

│   └── ReservationNotFoundException.java

│

└── utils/

&#x20;   └── ConfirmationGenerator.java

```



\---



\## Desain Class



\### Flight



Menyimpan informasi penerbangan:



\- Flight Number

\- Origin

\- Destination

\- Travel Date

\- Available Seats

\- Price



\### Hotel



Menyimpan informasi hotel:



\- Hotel ID

\- Hotel Name

\- Location

\- Price Per Night



\### Reservation (Abstract Class)



Superclass untuk seluruh reservasi.



Field:



\- Confirmation Number

\- Customer Name

\- Contact



Subclass:



\- FlightReservation

\- HotelReservation



\### Bookable (Interface)



Berisi method:



```java

void book();

void cancel();

```



\---



\## Konsep OOP yang Digunakan



\### Encapsulation



Seluruh atribut menggunakan access modifier private dan diakses melalui getter.



Contoh:



```java

private String flightNumber;

```



\---



\### Inheritance



```text

Reservation

&#x20;   │

&#x20;   ├── FlightReservation

&#x20;   │

&#x20;   └── HotelReservation

```



\---



\### Polymorphism



Method display() dioverride oleh masing-masing subclass.



```java

Reservation::display

```



\---



\### Abstraction



Menggunakan abstract class:



```java

public abstract class Reservation

```



\---



\### Interface



Menggunakan interface:



```java

public interface Bookable

```



\---



\## Fitur Java 17 yang Digunakan



\### Sealed Class



```java

public sealed abstract class Reservation

permits FlightReservation, HotelReservation

```



Membatasi subclass yang dapat mewarisi Reservation.



\---



\### Pattern Matching



```java

if(target instanceof FlightReservation fr)

```



Menghilangkan kebutuhan casting manual.



\---



\### Lambda Expression



```java

.filter(f ->

&#x20;   f.getDestination()

&#x20;    .equalsIgnoreCase(destination))

```



\---



\### Stream API



```java

flights.stream()

```



Digunakan untuk filtering dan pemrosesan koleksi.



\---



\## Exception Handling



\### Built-in Exception



```java

InputMismatchException

```



Digunakan untuk menangani kesalahan input user.



\### Custom Exception



```java

ReservationNotFoundException

```



Digunakan ketika nomor reservasi tidak ditemukan.



\---



\## Sample Data



\### Flight



| Flight No  | Origin  | Destination | Date       | Seats | Price      |

|------------|---------|-------------|------------|-------|------------|

| GA101      | Jakarta | Bali        | 2026-07-01 | 10    | 1.500.000  |

| JT202      | Jakarta | Surabaya    | 2026-07-01 | 15    | 900.000    |

| ID303      | Bandung | Bali        | 2026-07-02 | 8     | 1.200.000  |



\### Hotel



| Hotel ID | Hotel Name    | Location | Price     |

|----------|---------------|----------|-----------|

| H001     | Grand Bali    | Bali     | 800.000   |

| H002     | Luxury Resort | Bali     | 1.200.000 |

| H003     | Surabaya Inn  | Surabaya | 500.000   |



\---



\## Cara Menjalankan Program



\### Compile



```bash

javac Main.java

```



\### Run



```bash

java Main

```



\---



\## Contoh Penggunaan



\### Search Flight



Input:



```text

Origin      : Jakarta

Destination : Bali

Date        : 2026-07-01

```



Output:



```text

GA101 | Jakarta -> Bali | 2026-07-01 | Seat:10 | Rp 1500000

```



\---



\### Booking Flight



Input:



```text

Choose Flight : 1

Name          : Hagy

Contact       : 08123456789

```



Output:



```text

Booking Success.

Confirmation Number : 456789

```



\---



\### Cancel Reservation



Input:



```text

Confirmation Number : 456789

```



Output:



```text

Flight booking cancelled.

Reservation removed.

```



\---



\## Testing Scenarios



\### Valid Scenarios



\- Search flight available

\- Search hotel available

\- Book flight

\- Book hotel

\- View reservations

\- Cancel reservation



\### Invalid Scenarios



\- Flight not found

\- Hotel not found

\- Invalid menu input

\- Invalid reservation number

\- Invalid reservation selection



\---



\## Kesimpulan



Travel Booking System berhasil mengimplementasikan seluruh fitur utama yang diminta pada studi kasus, serta menerapkan prinsip Object-Oriented Programming dan fitur Java 17 seperti Sealed Class, Pattern Matching, Lambda Expression, Stream API, dan Exception Handling.

