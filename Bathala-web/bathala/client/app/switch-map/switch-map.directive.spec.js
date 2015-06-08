'use strict';

describe('Directive: switchMap', function () {

  // load the directive's module
  beforeEach(module('bathalaApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<switch-map></switch-map>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the switchMap directive');
  }));
});