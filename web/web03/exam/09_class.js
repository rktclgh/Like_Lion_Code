class FruitManager {
    constructor() {
        this.fruit_list = [
            { name: "사과", color: "빨강" },
            { name: "바나나", color: "노랑" },
            { name: "포도", color: "보라" },
        ];
    }

    addFruit(name, color) {
        this.fruit_list.push({ name, color });
    }

    printFruits() {
        this.fruit_list.forEach((fruit) => {
            console.log(`${fruit.name}: ${fruit.color}`);
        });
    }

    removeFruit(name) {
        const index = this.fruit_list.findIndex(f => f.name === name);
        if (index !== -1) {
            this.fruit_list.splice(index, 1);
            console.log(`Removed ${name}`);
        } else {
            console.log("과일이 없어!");
        }
    }

    updateFruit(name, newColor)
    {
        const fruit_one = this.fruit_list.find(f => f.name === name);
        if(fruit_one)
        {
            fruit_one.name = newColor;
            console.log(`Updated ${name} to ${newColor}`);
        }
        else{
            console.log("과일이 없어!");
        }
    }
}

// ✅ 클래스 외부에서 실행
const manager = new FruitManager();

manager.printFruits();
manager.addFruit("키위", "초록");
manager.printFruits();
manager.removeFruit("바나나");
manager.printFruits();

manager.updateFruit("사과", "빨간색");
manager.printFruits();
