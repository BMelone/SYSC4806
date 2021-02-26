const SinglePageApp = {
    setup: function () {
        $.ajax({
            url: window.location.origin + "/addressBooks"
        }).then(function(data) {
            $('#base').append(data);
        });

        $(document).on('click', '.add-address-book', SinglePageApp.clickAddAddressBook);
    }
    ,clickAddAddressBook: function () {
        $.ajax({
            type: 'POST',
            url: window.location.origin + "/addressBooks",
            timeout: 5000,
            success: SinglePageApp.addAddressBook,
            error: function (xhrObj, textStatus, exception) {
                alert('Error !');
            }
            // 'success ' and 'error ' functions will be passed 3 args
        });
        return (false);
    }
    ,addAddressBook: function(data, requestStatus, xhrObject) {
        $.ajax({
            url: window.location.origin + "/addressBooks"
        }).then(function(data) {
            document.body.innerHTML = data;
        });

        return (false); // prevent default link action
    }
};
$(SinglePageApp.setup);