# Beispielprojekt 

## Person
* Name
* Vorname
* Anrede
* Adresse
* Rechnungsadresse (opt)

## Unternehmen
 * Firma
 * Ansprechpartner
   * Name
   * Vorname
   * Anrede
 * Adresse

## Vertrag
* Art [Strom, Gas, Wasser]
* Kunde [Person, Unternehmen]
* Versorger [Person, Unternehmen]
* Abschlag

## Tarif
* Abrechnungseinheit [kwH, m³ Wasser, m³ Gas]
* Preis pro Einheit
* Grundpreis
* Einrichtungspreis

## Zähler
* Nummer
* Art [Stromzähler, Wasseruhr, Gaszähler]
* aktueller Messwert
* Korrekturfaktor (Gas)

## Abrechnungsdaten
 * Art [Konto, Paypal, Lastschrift, Kreditkart]
 * BIC
 * IBAN
 * Paypaladresse
 * SEPA Mandat
 * Kreditkarte

## Objekte
* Adresse
* Typ (Haus, Wohnung, PV Anlage)