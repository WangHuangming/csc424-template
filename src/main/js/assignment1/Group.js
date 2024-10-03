class Group {
    #contents;

    constructor() {
        this.#contents = [];
    }

    has(x) {
        return this.#contents.includes(x);
    }

    add(x) {
        if (!this.has(x)) {
            this.#contents.push(x);
        }
    }

    delete(x) {
        try{
            if (this.has(x)){
                this.#contents = this.#contents.filter(element => element !== x);
            }else{
                throw new Error('There is no such an element')
            }
        }catch{
            ;
        }
    }

    static from(it) {
        let result = new Group();
        for (let x of it) {
            result.add(x);
        }
        return result;
    }
}

function main() {
    let group = Group.from([10, 20]);
    console.log(group.has(10));
    // → true
    console.log(group.has(30));
    // → false
    group.add(10);
    group.delete(10);
    console.log(group.has(10));
    // → false
}

if (require.main === module) {
    main();
}

module.exports = Group;