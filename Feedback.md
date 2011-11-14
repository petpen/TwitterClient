Peter Pensold
# Feedback
##Dokumentation
Die Dokumentation führt durch den Prozess des Einrichtens und der Konfiguration der Anwendung. Trotz des recht aufwändigen Vorgangs ist die Dokumentation dafür ausreichend.

Leider war trotz guter Dokumentation das Programm nicht lauffähig, da die Schritte für die Einrichtung als Twitter-Application nicht korrekt beschrieben wurden.

##Git- und Github-Nutzung
Gerade am Anfang wurden sehr große Commits gemacht. Git erlaubt es Zwischenstände zu committen, so dass der Vorgang der Entwicklung nachvollziehbar wird. Eine .gitignore-Datei fehlt, die dafür sorgt das keine Class-Dateien von Git getrackt werden.


##Funktionalität
Die Funktionalität wurde vollständig, nach den Vorgaben umgesetzt. Der Client wird als App eingerichtet und kann dadurch Nutzern folgen. Er reagiert auf Mentions und antwortet, ebenfalls via Mention.


##Code
Der Code ist sehr modular gehalten und daher jeweils sehr einfach und kurz. Die Main-Methode besteht nur aus dem Starten des Clients und ist so auch ohne Tests in einer weiteren Entwicklung sehr gut einsetzbar.

Die beiden Exception-Klassen, dienen nur als "Marker" und haben geben keine zusätzlichen Informationen. Daher hätten auch generische Exceptions mit einer entsprechenden Message verwendet werden können. Aus der Perspektive des Testens, erleichtern Custom-Exceptions jedoch das Testen von Ausnahmen.

Was Auffällt ist die Verwendung von Instanzvariablen. Teilweise sind diese natürlich notwendig, jedoch sollte dies immer hinterfragt werden. In dem Fall, dass viele Instanzvariablen notwendig erscheinen, kann entweder über den Einsatz einer HashMap nachgedacht werden oder ein reines Datenobjekt verwendet werden. Dadurch erleichtert sich das austauschen der Daten, die Initialisierung und das Testen mit Hilfe von Attrappen.

Die Konfiguration der Anwendung durch den Austausch der Credentials im Quellcode erhöht den Aufwand bei der Einrichtung der Software beträchtlich. Hier wäre die Option ein .properties-File zu nutzen, um einiges besser gewesen.

***
Bewertung: Ich bewerte die Abgabe mit 4Punkten.
