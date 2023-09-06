import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat dF = new DecimalFormat("###,###.##");
        /*
         * С помощью цикла while посчитайте, сколько месяцев потребуется, чтобы накопить
         * 2 459 000 рублей при условии, что первоначально мы имеем 0 рублей и готовы
         * откладывать по 15 тысяч рублей.
         * Результат программы должен быть выведен в консоль с тем количеством месяцев,
         * которое необходимо для накопления данной суммы. Формат сообщения: «Месяц …,
         * сумма накоплений равна … рублей» .
         */
        System.out.println("Задача 1.");
        int limit = 2_459_000;
        int amountSavings = 0;
        int monthCount = 0;
        while (amountSavings <= limit) {
            amountSavings += 15_000;
            monthCount++;
        }
        System.out.println("Месяц " + dF.format(monthCount) + ", сумма накоплений равна "
                + dF.format(amountSavings) + " рублей.\n");

        /*
         * Выведите в одну строку через пробел числа от 1 до 10 с помощью цикла while.
         * На следующей строке выведите числа в обратном порядке от 10 до 1 с помощью цикла for.
         * Для обоих циклов можно использовать как одну общую переменную, так и свою в каждом цикле.
         * Не забудьте выполнить переход на новую строку между двумя циклами.
         * В результате программы вывод должен получиться следующим:
         * 1 2 3 4 5 6 7 8 9 10
         * 10 9 8 7 6 5 4 3 2 1
         */
        System.out.println("Задача 2.");
        int number = 1;
        while (number < 11) {
            System.out.print(number + " ");
            number++;
        }
        System.out.println();
        for (number--; number > 0; number--) {
            System.out.print(number + " ");
        }
        System.out.println("\n");

        /*
        В стране Y население — 12 миллионов человек.
        Рождаемость составляет 17 человек на 1000, смертность — 8 человек. Рассчитайте,
        какая численность населения будет через 10 лет, если показатели рождаемости и
        смертности постоянны. В консоль выведите результат операции на каждый год в формате: «Год …,
        численность населения составляет …».
        */
        System.out.println("Задача 3.");
        int population = 12_000_000;
        int increase = 17;
        int reduction = 8;
        int absoluteChange = increase - reduction;
        int numberOfNewPeople;
        for (int i = 0; i < 10; i++) {
            numberOfNewPeople = (population / 1000) * absoluteChange;
            population += numberOfNewPeople;
            System.out.println("Год " + (i + 1) + ", численность населения составляет "
                    + dF.format(population) + " человек.");
        }
        System.out.println();
        /*
        Василий решил положить деньги на накопительный счет, где каждый месяц к сумме
        его вклада добавляется еще 7%. Первоначальная сумма вклада — 15 тысяч рублей.
        Вычислите и выведите в консоль, сколько месяцев Василию нужно будет копить,
        чтобы собрать сумму в 12 миллионов рублей при условии, что процент банка от
        накоплений не меняется, а всегда равен 7%.
        Выведите в консоль результат программы с указанием суммы накоплений по каждому месяцу.
        */
        System.out.println("Задача 4.");
        float percent = 7F;
        float savingsLimit = 12_000_000F;
        float monthlyFee = 15_000F;
        float savings = 0F;
        int numberOfMonth = 1;

        while (savings < savingsLimit) {
            savings += (savings / 100) * 7;
            savings += monthlyFee;
            System.out.print("Сумма накоплений за " + numberOfMonth +
                    " месяц равна " + dF.format(savings) + " рублей.");
            System.out.println();
            numberOfMonth++;
        }
        System.out.println("Для накопления " + dF.format(savingsLimit) +
                " рублей, при " + percent + "% от банка ежемесячно, необходимо " +
                (numberOfMonth - 1) + " месяцев.\n");

        /*
        Видоизмените программу таким образом, чтобы в консоль выводились не все
        месяцы подряд, а только каждый шестой. Должны быть видны накопления за 6-й,
        12-й, 18-й, 24-й и следующие месяцы.
        */
        System.out.println("Задача 5.");
        savings = 0F;
        numberOfMonth = 1;
        while (savings < savingsLimit) {
            savings += (savings / 100) * 7;
            savings += monthlyFee;
            if (numberOfMonth % 6 == 0) {
                System.out.print("Сумма накоплений за " + numberOfMonth +
                        " месяц равна " + dF.format(savings) + " рублей.");
                System.out.println();
            }
            numberOfMonth++;
        }
        System.out.println("Для накопления " + dF.format(savingsLimit) +
                " рублей, при " + percent + "% от банка ежемесячно, необходимо "
                + (numberOfMonth - 1) + " месяцев.\n");

        /*
        Василий решил, что будет копить деньги ближайшие 9 лет. Он хочет знать, какой
        будет сумма его накоплений каждые полгода на протяжении этих 9 лет.
        Исходная сумма всё та же — 15 тысяч рублей, проценты банка — 7% ежемесячно.
        Напишите программу, которая будет выводить сумму накоплений за каждые
        полгода в течение 9 лет.
        */
        System.out.println("Задача 6.");
        savings = 0F;
        numberOfMonth = 1;
        int timeLimit = 9 * 12;
        while (numberOfMonth <= timeLimit) {
            savings += (savings / 100) * 7;
            savings += monthlyFee;
            if (numberOfMonth % 6 == 0) {
                System.out.print("Сумма накоплений за " + numberOfMonth +
                        " месяц равна " + dF.format(savings) + " рублей.");
                System.out.println();
            }
            numberOfMonth++;
        }
        System.out.println("\n");
        /*
        В компании пятница — отчетный день.
        Нужно написать программу, которая считает дни месяца по датам, определяет,
        какой день — пятница, и выводит сообщение с напоминанием, что нужно
        подготовить еженедельный отчет.
        Создайте переменную типа int, которая хранит в себе номер первой пятницы
        месяца (число от 1 до 7).
        Выведите на каждую пятницу месяца (включая полученную) сообщение
        следующего вида: «Сегодня пятница, ...-е число. Необходимо подготовить отчет».
        В нашем месяце 31 день. В результате у вас должно получиться от 4 до 5 сообщений
        с напоминаниями по разным датам.
        */
        System.out.println("Задача 7.");
        int dateOfFriday = 1;
        int currentDay = 1;
        int daysInMonth = 31;
        while (dateOfFriday <= daysInMonth) {
            if (currentDay == dateOfFriday) {
                System.out.println("Сегодня пятница " + currentDay + "-e число. Необходимо подготовить отчёт.");
                dateOfFriday += 7;
            }
            currentDay++;
        }
        System.out.println("\n");
        /*
        Нам нужно написать астрономическое приложение, которое считает, когда над
        Землей пролетает комета.
        Известно, что комета пролетает каждый 79-й год, начиная с нулевого.
        В консоль нужно вывести все годы за последние 200 лет, когда появлялась комета,
        а также следующий год ее появления (ближайшие 100 лет).
        Для вычисления периода можно создать две дополнительные переменные,
        которые содержат год за 200 лет до текущего (из созданной ранее переменной) в
        качестве старта и 100 лет после в качестве завершения периода расчета.
        В результате решения задачи в консоли должен получиться следующий результат:
        1896
        1975
        2054
         */
        System.out.println("Задача 8.");
        int yearWithCommet = 0;
        int periodCommet = 79;
        int currentYear = 2023;
        while (yearWithCommet <= currentYear+100) {
            if (yearWithCommet > currentYear - 200 && yearWithCommet < currentYear + 100) {
                System.out.println(yearWithCommet);
            }
            yearWithCommet += periodCommet;
        }
    }
}