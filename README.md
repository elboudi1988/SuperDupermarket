# SuperDupermarket

Design Patterns



Bei der Implementierung des Codes wurden verschiedene Design Patterns verwendet, um die Struktur, Flexibilität und Wartbarkeit zu verbessern.

Iterator Pattern: Das Iterator Pattern wurde verwendet, um auf die Liste der Produkte zuzugreifen. Die Verwendung der For-Each-Schleife in Verbindung mit dem Iterator ermöglicht es, auf jedes Element in der Liste zuzugreifen, ohne sich um die interne Implementierung kümmern zu müssen. Dadurch wird die Iteration über die Liste erleichtert und die Lesbarkeit des Codes verbessert.

Template Method Pattern: Das Template Method Pattern wurde in der Product-Klasse verwendet, um den Algorithmus für die Aktualisierung der Qualität zu definieren. Die Methode "updateQuality" stellt den übergeordneten Algorithmus bereit, während die spezifischen Schritte in den Unterklassen implementiert werden können. Dadurch kann der allgemeine Algorithmus beibehalten werden, während spezifische Anpassungen in den Unterklassen möglich sind.

Repository-Klasse:

Die Repository-Klasse in meinem Code fungiert als Datenzugriffsschicht für Produkte und wurde aus mehreren Gründen implementiert.

Abstraktion von Datenquellen: Die Repository-Klasse ermöglicht den Zugriff auf Produktinformationen unabhängig von der spezifischen Datenquelle. Sie dient als Schnittstelle zwischen dem Aufrufer und den zugrunde liegenden Datenquellen und ermöglicht eine lose Kopplung.

Unterstützung verschiedener Datenquellen: Die Repository-Klasse unterstützt verschiedene Datenquellen, darunter eine Datenbank und eine CSV-Datei. Es wurden entsprechende Methoden implementiert, um die Produkte aus der Datenbank abzurufen und aus einer CSV-Datei zu lesen. Dadurch wird Flexibilität in der Wahl der Datenquelle ermöglicht.

Fallback-Mechanismus: Falls keine Datenbankverbindung verfügbar ist oder die CSV-Datei nicht vorhanden ist, greift die Repository-Klasse auf vordefinierte Testdaten zurück. Dadurch wird eine zuverlässige Bereitstellung von Produktinformationen gewährleistet.

Durch die Implementierung der Repository-Klasse wird eine klar strukturierte und wiederverwendbare Komponente geschaffen, die den Datenzugriff vereinfacht und die Wartbarkeit des Codes verbessert.
![image](https://github.com/elboudi1988/SuperDupermarket/assets/102913853/1472ee01-c3ca-459c-bd95-2eb66fedec67)


![Bildschirm­foto 2023-05-22 um 15 56 44](https://github.com/elboudi1988/SuperDupermarket/assets/102913853/860a6efd-93af-42e1-a551-8f993b1f159a)


![Bildschirm­foto 2023-05-22 um 15 57 02](https://github.com/elboudi1988/SuperDupermarket/assets/102913853/50970266-947c-4a4d-9a3c-43b51066fa9e)


![Bildschirm­foto 2023-05-22 um 17 47 00](https://github.com/elboudi1988/SuperDupermarket/assets/102913853/acd31918-acb7-43a5-88f1-c8620ed54dec)





