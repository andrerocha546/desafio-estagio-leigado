<template>
    <header id="header">
        <h1>{{ title }}</h1>
    </header>
</template>

<script>

export default {
    name: "Header",
    props: {
        title: String
    }
}

</script>

<style>

    #header {
        grid-area: header;
    }

</style>
