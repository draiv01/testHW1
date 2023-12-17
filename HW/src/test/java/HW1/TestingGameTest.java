package HW1;

import org.example.HW1.Door;
import org.example.HW1.Game;
import org.example.HW1.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestingGameTest {
    static List<Door> doors; // создаем три двери

    // 1) методы лучше называть с маленькой буквы doors()
    // 2) метод @BeforeALl должен быть статик, либо аннотировать весь класс с помощью @TestInstance(Lifecycle.PER_CLASS).
    @BeforeAll // можно использовать @BeforeAll, т.к. один и тот же список используется во всех тестах
    void Doors() {
        doors = new ArrayList<>();
        //инициализацию дверей надо вынести в @BeforeEach, т.к. метод game.round удаляет дверь из списка
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
    }

    @Test
        //  если игрок не меняет дверь выбрав приз и выигрывает
    void WinNotChangeDoor() {
        //given - предусловия теста
        Player player = new Player("Игрок", false); // не меняет дверь
        Game game = new Game(player, doors);
        //when - вызов функционала, который мы проверяем
        Door door = game.round(0);
        // then — описываются утверждения
        Assertions.assertTrue(door.isPrize());
    }

    @Test
        //  если игрок меняет дверь выбрав приз и проигрывает
    void LoseChangeDoor() {
        //given - предусловия теста
        Player player = new Player("Игрок", true); // меняет дверь
        Game game = new Game(player, doors);
        //when - вызов функционала, который мы проверяем
        Door door = game.round(0);
        // then — описываются утверждения
        Assertions.assertFalse(door.isPrize());
    }

    @Test
        //  если игрок меняет дверь выбрав не приз и выигрывает
    void WinChangeDoor() {
        //given - предусловия теста
        Player player = new Player("Игрок", true); // меняет дверь
        Game game = new Game(player, doors);
        //when - вызов функционала, который мы проверяем
        Door door = game.round(1);
        // then — описываются утверждения
        Assertions.assertTrue(door.isPrize());
    }

    @Test
        // если игрок не меняет дверь выбрав не приз и проигрывает
    void LoseNotChangeDoor() {
        //given - предусловия теста
        Player player = new Player("Игрок", false); // не меняет дверь
        Game game = new Game(player, doors);
        //when - вызов функционала, который мы проверяем
        Door door = game.round(1);
        // then — описываются утверждения
        Assertions.assertFalse(door.isPrize());
    }
}
