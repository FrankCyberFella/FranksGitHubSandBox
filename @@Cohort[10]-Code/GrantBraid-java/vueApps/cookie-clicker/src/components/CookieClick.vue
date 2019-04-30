<template>

    <div id="container">
        <div id="clicker">
            <p>{{point}}</p>
            <button id="inc" v-on:click="increase">Click</button>  
            <h3>{{now}}</h3>
            <h3>Points/sec : {{pointsPerSec}}</h3>
        </div>
        <div id="auto-click">
            <h2>Grandma ({{grandmaCost}}, 0.5 points/sec) <button id="grand" v-on:click="grandma">Buy 1</button> owned: {{ownedGrandma}}</h2>
            <h2>Wheelbarrow ({{wheelbarrowCost}}/ 8 points/sec) <button id="wheel" v-on:click="wheelbarrow">Buy 1</button> owned: {{ownedWheelbarrow}} </h2>
            <h2>Magic Wheelbarrow ({{magicWheelCost}}/ 47 points/sec) <button id="magicWheel" v-on:click="magicWheelbarrow">Buy 1</button> owned: {{ownedMagicWheel}} </h2>
            <h2>Cargo Ship ({{cargoCost}}/ 150 points/sec) <button id="cargoShip" v-on:click="cargo">Buy 1</button> owned: {{ownedCargo}} </h2>
        </div>

    </div>
</template>

<script>

export default {
    name: 'cookie-click',
    data() {
        return {
            point: 0,
            ownedGrandma: 0,
            grandmaCost: 100,
            now: new Date,
            dateHold: '',
            ownedWheelbarrow: 0,
            wheelbarrowCost: 1100,
            ownedMagicWheel: 0,
            magicWheelCost: 12000,
            cargoCost: 100000,
            ownedCargo: 0,

            pointsPerSec: 0,
        }
    },
    methods: {
        increase() {
            this.point += 1;
        },
        grandma() {
            if (this.point >= this.grandmaCost) {
                this.point -= this.grandmaCost;
                this.grandmaCost *= 1.15;
                this.grandmaCost = Math.round(this.grandmaCost);
                this.ownedGrandma += 1;
            }
        },
        wheelbarrow() {
            if  (this.point >= this.wheelbarrowCost) {
                this.point -= this.wheelbarrowCost;
                this.ownedWheelbarrow+=1;
                this.wheelbarrowCost = Math.round(1.15*this.wheelbarrowCost);

            }
        },
        magicWheelbarrow() {
            if (this.point >= this.magicWheelCost) {
                this.point -= this.magicWheelCost;
                this.ownedMagicWheel += 1;
                this.magicWheelCost = Math.round(1.15*this.magicWheelCost);
            }
        },
        cargo() {
            if (this.piont >= this.cargoCost) {
                this.point -= this.cargoCost;
                this.ownedCargo += 1;
                this.cargoCost = Math.round(1.15*this.cargoCost);
            }
        }
    },
    created () {

        setInterval(() => {
            this.point += this.ownedGrandma*0.5;
            this.point += this.ownedWheelbarrow*8;
            this.point += this.ownedMagicWheel*47;
            this.point += this.ownedCargo*150;

            this.pointsPerSec = this.ownedGrandma*0.5 + this.ownedWheelbarrow*8 + this.ownedMagicWheel*47 + this.ownedCargo*150;
            this.now = new Date}, 1000 // should be 1000 for 1 per second

        );
    }

    
}
</script>

<style>
p {
    font-size: 250%;
}
#clicker button {
    font-size: 200%;
}
#container {
    display: flex;
    justify-content: space-around;
    flex-direction: row;
}
#auto-click button {
    font-size: 100%;
}

</style>
