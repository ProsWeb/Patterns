//In this task, you will implement almost a full code. Your computer is some kind of a facade for you as a user, or developers put it, a client. Let's create a simple ComputerFacade with Processor, Monitor and Keyboard subsystems. When you turn on this computer, Processor will start first, then Monitor and finally Keyboard. But be careful, because your keyboard has backlight and the turning off order should be correct!
//
//        Sample Input 1:
//
//        Sample Output 1:
//
//        Processor on
//        Monitor on
//        Keyboard on
//        Backlight is turned on
//        Keyboard off
//        Backlight is turned off
//        Monitor off
//        Processor off

package patterns.facade;

class ComputerFacadeTestDrive {
    public static void main(String[] args) {
        Processor processor = new Processor();
        Monitor monitor = new Monitor();
        Keyboard keyboard = new Keyboard();


        ComputerFacade computerFacade = new ComputerFacade(processor, monitor, keyboard);

        computerFacade.turnOnComputer();
        computerFacade.turnOffComputer();
    }
}

class ComputerFacade {
    Processor processor;
    Monitor monitor;
    Keyboard keyboard;

    public ComputerFacade(Processor processor, Monitor monitor, Keyboard keyboard) {
        this.processor = processor;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public void turnOnComputer() {
        processor.on();
        monitor.on();
        keyboard.on();
    }

    public void turnOffComputer() {
        keyboard.off();
        monitor.off();
        processor.off();
    }
}

class Processor {
    private String description = "Processor";

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }
}

class Monitor {
    private String description = "Monitor";

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }
}

class Keyboard {
    private String description = "Keyboard";
    private String backlight = "Backlight";

    public void on() {
        System.out.println(description + " on");
        turnOnBacklight();
    }

    public void off() {
        System.out.println(description + " off");
        turnOffBacklight();
    }

    private void turnOnBacklight() {
        System.out.println(backlight + " is turned on");
    }

    private void turnOffBacklight() {
        System.out.println(backlight + " is turned off");
    }
}

