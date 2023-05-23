# SuperDupermarket

Design Patterns:

Iterator Pattern: Das Iterator Pattern ermöglicht den einfachen Zugriff auf die Liste der Produkte, ohne sich um die interne Implementierung kümmern zu müssen. Durch die Verwendung der For-Each-Schleife in Verbindung mit dem Iterator wird die Iteration über die Liste erleichtert und der Code wird lesbarer.
Template Method Pattern: Das Template Method Pattern wurde in der Product-Klasse verwendet, um den Algorithmus für die Aktualisierung der Qualität zu definieren. Der übergeordnete Algorithmus wird in der Methode "updateQuality" bereitgestellt, während spezifische Schritte in den Unterklassen implementiert werden können. Dadurch bleibt der allgemeine Algorithmus erhalten und spezifische Anpassungen sind möglich.
Repository-Klasse:
Die Repository-Klasse dient als Datenzugriffsschicht für Produkte und wurde aus folgenden Gründen implementiert:

Abstraktion von Datenquellen: Die Repository-Klasse ermöglicht den Zugriff auf Produktinformationen unabhängig von der spezifischen Datenquelle. Sie fungiert als Schnittstelle zwischen dem Aufrufer und den zugrunde liegenden Datenquellen und ermöglicht eine lose Kopplung.

Unterstützung verschiedener Datenquellen: Die Repository-Klasse unterstützt verschiedene Datenquellen wie eine Datenbank und eine CSV-Datei. Es wurden entsprechende Methoden implementiert, um Produkte aus der Datenbank abzurufen und aus einer CSV-Datei zu lesen. Dadurch wird die Flexibilität bei der Auswahl der Datenquelle gewährleistet.

Fallback-Mechanismus: Falls keine Datenbankverbindung besteht oder die CSV-Datei nicht vorhanden ist, greift die Repository-Klasse auf vordefinierte Testdaten zurück. Dadurch wird eine zuverlässige Bereitstellung von Produktinformationen sichergestellt.

Die Implementierung der Repository-Klasse schafft eine gut strukturierte und wiederverwendbare Komponente, die den Datenzugriff vereinfacht und die Wartbarkeit des Codes verbessert.


# Ergebnisse 


![Bildschirm­foto 2023-05-22 um 15 56 44](https://github.com/elboudi1988/SuperDupermarket/assets/102913853/860a6efd-93af-42e1-a551-8f993b1f159a)


![Bildschirm­foto 2023-05-22 um 15 57 02](https://github.com/elboudi1988/SuperDupermarket/assets/102913853/50970266-947c-4a4d-9a3c-43b51066fa9e)


![Bildschirm­foto 2023-05-22 um 17 47 00](https://github.com/elboudi1988/SuperDupermarket/assets/102913853/acd31918-acb7-43a5-88f1-c8620ed54dec)





