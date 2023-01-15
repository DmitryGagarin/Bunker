package bunker;

public class Utils2 extends AllCheckers {

    public static int percentageOfStrongDoor;
    public static int luck;
    public static int whoGetTheWeapon;

    //начальный кусок текста
    public static void partOfText1(){
        System.out.println("Вы просыпаетесь. Будите команду и вспоминаете, что было вчера.");
        System.out.println("Нужно срочно проверить припасы, оружие и медикаменты и приготовится к бою за защиту бункера.");
        System.out.println("Но перед началом надо позавтракать, ведь хороший завтрак самая главная вещь перед боем.");
    }

    public static void partOfText2(){
        System.out.println("После долгожданного завтрака пришло время готовить укрытие");
        System.out.println(" \"Как будем обороняться, шеф? \" - задает вопрос " + myAllNeighbours.get(1) + ".");
        System.out.println(ANSI_BLUE + "Будем делать баррикады (1), делаем зассаду в бункере (2), будем надеяться, что ничего не произойдет (3)." + ANSI_RESET);
        int decision = Utils.getNum(1,3);
        if (decision == 1){
             decision1();
        }
        if (decision == 2){
            decision2();
        }
        if (decision == 3){
            decision3();
            System.exit(0);
        }
    }

    public static void decision1() {
        System.out.println("Было принято решение стоить баррикады. Одну, чтобы загородить дверь, вторую в качестве обороны");
        checkCharactersToBuilders();
    }

    public static void checkCharactersToBuilders(){
        if (peopleInBunker.contains("Грузчик") || peopleInBunker.contains("Дровосек") || peopleInBunker.contains("Инженер") ||
                peopleInBunker.contains("Плотник") || peopleInBunker.contains("Сантехник") || peopleInBunker.contains("Строитель") ||
                peopleInBunker.contains("Фермер") || peopleInBunker.contains("Электрик")){
            System.out.println("Вам повезло, среди вас есть люди, способные работать руками. С помощью них крепкость баррикады возрастает в несколько раз.");
            percentageOfStrongDoor = 50 + (int) (Math.random() * 100);
            partOfText3();
        }
        else {
            System.out.println("Среди вас, к сожалению, не оказалось профессионалов по баррикадам.");
            System.out.println("Тем не менее, надо трудиться изо всех сил, ведь от этого зависит ваша жизнь.");
            percentageOfStrongDoor = (int) (Math.random() * 50);
            partOfText4();
        }
    }

    public static void partOfText3(){
        System.out.println("Вы разбираете шкаф, затем стол, кресла, мебель с других комнат, из одежды и мусора делаете веревки.");
        System.out.println("На ваше удивление, защита вышла довольно крепкая");
        System.out.println("Отличный результат, надеемся, что пока мародеры будут ломиться к вам, они устанут и передумают.");
        textAfterActivity1();
    }

    public static void partOfText4(){
        System.out.println("Вы злостно ломаете шкаф, кое-как накидываете доски на дверь, думая, что вам это поможет.");
        System.out.println("Шанс, что это спасет вас очень и очень мал.");
        textAfterActivity1();
    }

    public static void textAfterActivity1() {
        System.out.println("Как только вы доделали свои баррикады, вы слышите стук в дверь. Вы вооружаетесь, становитесь на позиции.");
        System.out.println("Через минуту дверь взрвывается, ваши баррикады вам мало чем помогли, но тем не менее вам надо обороняться.");
        System.out.println("Бой начался!!!");
    }

    public static void decision2() {
        System.out.println("Вам показалось, что устроить зассаду является оптимальным решением.");
        checkCharactersToSoldier();
    }

    public static void checkCharactersToSoldier(){
        if (peopleInBunker.contains("Инструктор По Выживанию") || peopleInBunker.contains("Полицейский") || peopleInBunker.contains("Телохранитель")){
            System.out.println("Вам повезло, среди вас оказались люди, прошедшие военную подготовку.");
            System.out.println("Они помогут организовать зассаду.");
            System.out.println("Выберите на какой территории организовать зассаду.");
            System.out.println(ANSI_BLUE + "Спрятаться в главной комнате (1), найти комнату в левом коридоре (2), найти комнату в правом коридоре (3)." + ANSI_RESET);
            decision2_1();
        }
        else {
            System.out.println("К сожалению, среди вас не оказалось людей с должной военной подготовкой, поэтому решение вы будете принимать сами.");
            System.out.println("Единственная ваша идея это спрятаться в самое дальней комнате бункера и надеяться, что мародеры пройдут мимо.");
            System.out.println("А если и зайдут к вам, то вы будете готовы");
            decision2_1_2();
        }
    }

    public static void decision2_1(){
        int decision = Utils.getNum(1,3);
        if (decision == 1) decision2_1_1();
        if (decision == 2 || decision == 3) decision2_1_2();
    }

    //решение при решении делать зассаду и наличие солдат спрятаться в главной комнате
    public static void decision2_1_1(){
        System.out.println("Зассада перед носом у врага, звучит авантюрно.");
        System.out.println("Вы разбираете мебель из других комнат, после чего закрываете двери в другие комнаты, рассходитесь по сторонам так, чтобы получился cross-fire.");
        System.out.println("По вашему мнению это должно вас защитить, главное, чтобы мародеров было немного.");
        luck = 10 + (int) (Math.random() * 30);
        System.out.println("Вы забились по углам, спрятали себя мебелью.");
        System.out.println("Спустя некоторое время происходит взрыв, в комнату забегает небольшая группа мародеров, завязывается перестрелка");
    }

    //решение при решении делать зассаду и наличие солдат спрятаться в других коридорах
    public static void decision2_1_2() {
        System.out.println("По вашему мнению, чем дальше сидишь, там легче защищаться.");
        System.out.println("Вы идете в самую дальнюю комнату этого коридора. Залезаете на кровати последнего ряда и ждете затаив дыхание.");
        luck = 1 + (int) (Math.random() * 10);
        textAfterActivity2();
    }

    public static void textAfterActivity2() {
        System.out.println("Спустя несколько часов вы слышите громкий взрыв, затем медленный шаги в вашем напралении");
        System.out.println("Вы видите как к вам в комнату заходит человек с фонариком. Он медленно обыскивает комнату, замечает вас и бежит обратно.");
        System.out.println("Вы спускаетесь с кроватей и бежите за ним, завязывается битва за бункер.");
    }

    //будем думать, что ничего не произойдет
    public static void decision3() {
        System.out.println("\"Если так подумать, то каков шанс, что эти люди придут именно к нам?\" ");
        System.out.println("Вы считаете, что паниковать не нужно, бункеров в городе много, а мародеров мало.");
        System.out.println("Ваши соседи пытаются вас переубедить, но ваше решение неизмененимо.");
        System.out.println("Как только вы садитесь на кресло, дверь взрывается, вас оглушает.");
        System.out.println("Через пыль вы замечаете, что кто-то входит в бункер. На этих людях черные берцы, их тела обвязаны патронами, а в руках по два автомата.");
        System.out.println(ANSI_RED + " \"Мы предупреждали, что мы придем, а вы даже не подготовились, бестолочи!\"" + ANSI_RESET);
        System.out.println("Вы ощущаете себя в фильме-боевике. Пока вы лежите и протираете глаза, на вас наводят дуло пистолета и стреляют...");
        System.out.println(ANSI_RED + "Игра окончена" + ANSI_RESET);
    }

    public static void howManyWeapon() {
        if (numberOfWeapon == 0) {
            numberOfWeapon0();
            Utils.reputation(-1);
        }
        if (numberOfWeapon == 1) {
            numberOfWeapon1();
            Utils.reputation(1);
        }
        if (numberOfWeapon == 2) {
            numberOfWeapon2();
            Utils.reputation(2);
        } else {
            numberOfWeaponMore();
            Utils.reputation(3);
        }
    }

    public static void numberOfWeapon0() {
        System.out.println("К сожалению, никакого оружия не было найдено. Будем надеяться, что они пошутили и никто не придет.");
        System.out.println("*нервный смех*");
        decision3();
        System.out.println(ANSI_RED + "В следующий раз нужно быть внимательней с выбором персонажа." + ANSI_RESET);
        System.exit(0);
    }

    public static void numberOfWeapon1() {
        System.out.println("В вашем инвентаре только одно оружие.");
        System.out.println("Этим оружием является: " + listOfWeaponInInventory + ". Кому вы хотите его отдать?");
        System.out.println("Оставить себе (1); отдать + " + myAllNeighbours.get(0) + "у (2) или " + myAllNeighbours.get(1) + "у (3)?");
        givingWeaponToPersonOneWeapon();
    }

    public static void givingWeaponToPersonOneWeapon() {
        int decision = getNum(1,3);
        if (decision == 1){
            System.out.println("Вы решаете, что капитану оружие нужнее, чем команде.");
            System.out.println("Команда немного расстроена вашим решением.");
            Utils.reputation(-1);
        }
        if (decision == 2){
            System.out.println("Лидер обязан заботиться о команде, поэтому вы отдаете оружие соседу.");
            System.out.println("Вы отдаете оружие " + myAllNeighbours.get(0) + "у.");
            System.out.println("Команда поддерживает ваше решением.");
            Utils.reputation(1);
        }
        if (decision == 3){
            System.out.println("Лидер обязан заботиться о команде, поэтому вы отдаете оружие соседу.");
            System.out.println("Вы отдаете оружие " + myAllNeighbours.get(1) + "у.");
            System.out.println("Команда поддерживает ваше решением.");
            Utils.reputation(1);
        }
    }

    public static void numberOfWeapon2() {
        System.out.println("В вашем инвенторе оказалось сразу два оружия. Этого должно хватить для защиты.");
        System.out.println("Выберите человека, которому хотите отдать " + listOfWeaponInInventory.get(0)+ ".");
        System.out.println(ANSI_BLUE + "Оставить себе (1); Отдать " + myAllNeighbours.get(0) + "у (2) или " + myAllNeighbours.get(1) + "у (3)." + ANSI_RESET);
        givingWeaponToPersonTwoWeapon1();
        givingWeaponToPersonTwoWeapons2();
    }

    public static void givingWeaponToPersonTwoWeapon1() {
        int decision = Utils.getNum(1,3);
        if (decision == 1){
            System.out.println("Вы решаете, что капитану оружие куда нужнее, чем команде.");
            System.out.println("Команда немного расстроена вашим решением.");
            Utils.reputation(-1);
            whoGetTheWeapon = 1;
        }
        if (decision == 2){
            System.out.println("Лидер обязан заботиться о команде, поэтому вы отдаете оружие соседу.");
            System.out.println("Немного подурачившись, вы отдаете оружие " + myAllNeighbours.get(0) + "у.");
            System.out.println("Команда поддерживает вашим решением.");
            Utils.reputation(1);
            whoGetTheWeapon = 2;
        }
        if (decision == 3){
            System.out.println("Лидер обязан заботиться о команде, поэтому вы отдаете оружие соседу.");
            System.out.println("Немного подурачившись, вы отдаете оружие " + myAllNeighbours.get(1) + "у.");
            System.out.println("Команда поддерживает вашим решением.");
            Utils.reputation(1);
            whoGetTheWeapon = 3;
        }
    }

    public static void givingWeaponToPersonTwoWeapons2(){
        if (whoGetTheWeapon == 1){ //себе уже выдал, выдаю любому соседу
            System.out.println("Осталось решить, кто соседей получит " + listOfWeaponInInventory.get(1) + ".");
            System.out.println(ANSI_BLUE + myAllNeighbours.get(0) + " (1) или " + myAllNeighbours.get(1) + " (2)." + ANSI_RESET);
            int decision = Utils.getNum(1,2);
            if (decision == 1 || decision == 2) givingWeaponToPersonTwoWeapons2_1();
        }
        if (whoGetTheWeapon == 2 || whoGetTheWeapon == 3){ //выдал первому соседу, выдаю либо себе, либо другому соседу
            System.out.println("Осталось решить, кто получит" + listOfWeaponInInventory.get(1) + ".");
            System.out.println(ANSI_BLUE + myAllNeighbours.get(1) + " (1) или вы (2)." + ANSI_RESET);
            int decision = Utils.getNum(1,2);
            if (decision == 1) givingWeaponToPersonTwoWeapons2_1();
            if (decision == 2) givingWeaponToPersonTwoWeapons2_2();
        }
        if (whoGetTheWeapon == 3){ //выдал второму соседу, выдаю либо себе, либо другому соседу
            System.out.println("Осталось решить, кто соседей получит" + listOfWeaponInInventory.get(1) + ".");
            System.out.println(ANSI_BLUE + myAllNeighbours.get(0) + " (1) или вы (2)." + ANSI_RESET);
            int decision = Utils.getNum(1,2);
            if (decision == 1) givingWeaponToPersonTwoWeapons2_1();
            if (decision == 2) givingWeaponToPersonTwoWeapons2_2();
        }
    }

    public static void givingWeaponToPersonTwoWeapons2_1() { //отдаете оружие соседу любому
        System.out.println("Вы отдаете оружие соседу");
        System.out.println("Таким образом оружие получает ваш сосед. Команда одобряет ваше решение.");
        Utils.reputation(1);
    }

    public static void givingWeaponToPersonTwoWeapons2_2() { //отдаете оружие себе
        System.out.println("Вы решаете, что капитану оружие куда нужнее, чем команде.");
        System.out.println("Команда немного расстроена вашим решением.");
        Utils.reputation(-1);
    }

    public static void numberOfWeaponMore() {
        if (listOfWeaponInInventory.size() == 3) System.out.println("Вам несказанно повезло - оружия хватило на всех, вы смогли его распределить.");
        else  System.out.println("Вам несказанно повезло - оружия хватило на всех, даже более того, оружия у вас с излишком.");
    }

    public static void numberOfWeaponPlus(int item){
        numberOfWeapon += item;
    }
}

