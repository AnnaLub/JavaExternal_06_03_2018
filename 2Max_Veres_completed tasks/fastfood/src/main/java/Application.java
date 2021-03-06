/*Свободная  касса.  В  ресторане  быстрого  обслуживания  есть  несколько касс.
        Посетители стоят в очереди в конкретную кассу, но могут перейти
        в другую очередь при уменьшении или исчезновении там очереди.*/
/*Разработать многопоточное приложение.
        Использовать возможности, предоставляемые пакетом java.util.concurrent.
        Не использовать слово synchronized.
        Все сущности, желающие получить доступ к ресурсу, должны быть потоками.
        Использовать возможности ООП.
        Не использовать графический интерфейс. Приложение должно быть кон-
        сольным.*/
public class Application {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 21; i++) {
            if(i%2!=0){
                new Thread(new Visitor(i)).start();
                Thread.sleep(100);
            }
            else{
                new Thread(new Visitor(i)).start();
                Thread.sleep(500);
            }

        }
    }
}

