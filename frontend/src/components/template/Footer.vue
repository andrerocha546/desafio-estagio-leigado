<template>
    <footer id="footer">
        <span>Copyright <strong>André Rocha</strong> ©2021</span>
    </footer>
</template>

<script>
export default {
    name: 'Footer'
}   
</script>

<style>
    #footer {
        grid-area: footer;
        background-color: #ddd;
        color: #333;

        display: flex;
        align-items: center;
        justify-content: center;
        padding-right: 10px;
    }
</style>