$(function () {
    var mainMenu = new HS.MainMenu($('#main-menu')),
        mainContentSwitcher = new HS.MainContentSwitcher($('#main-content')),
        networkConsistView = new HS.NetworkConsistView($('#dashboard').find('.ux-networkconsist-view')),
        inputTable = new HS.TableView($('#input-list')),
        inputDialog = new HS.InputFormDialog($('#input-form-dialog')),
        model = new HS.NetworkConsistModel(new HS.API());
    
    mainMenu.onSelect(function (target) {
        mainContentSwitcher.select(target);
    });
    
    $('#add-input').click(function () {
        inputDialog.open();
    });
    
    inputDialog.onConfirm(function (values) {
        model.createInput(values);
    });
    
    model.onInputAddition(function (input) {
        inputTable.addRow(input.id, input.host, input.name, input.value);
    });
    
    inputTable.onRemove(function (index) {
        model.removeInput(index);
    });
    
    model.onConsistUpdate(function (consist) {
        networkConsistView.setData(consist);
    });
    
    model.onConsistError(function () {
        networkConsistView.setInvalid();
    });
    
    if (location.hash) {
        mainMenu.select(location.hash.substr(1));
    }
    
    model.loadInitialData();
});