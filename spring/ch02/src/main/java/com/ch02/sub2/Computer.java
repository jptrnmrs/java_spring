package com.ch02.sub2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com")
public class Computer {
    // 필드 주입 (권장되지 않으나 상관없음)
    @Autowired
    private CPU cpu;

    // 생성자 주입 (권장됨)
    private RAM ram;

    @Autowired
    public Computer(RAM ram) {
        this.ram = ram;
    }

    // Setter 주입
    private SSD ssd;

    @Autowired
    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public void show(){
        cpu.show();
        ram.show();
        ssd.show();
    }
}
