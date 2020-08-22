import { NgModule } from '@angular/core';
import { InventorySharedLibsModule } from './shared-libs.module';
import { AlertComponent } from './alert/alert.component';
import { AlertErrorComponent } from './alert/alert-error.component';
import { HasAnyAuthorityDirective } from './auth/has-any-authority.directive';

@NgModule({
  imports: [InventorySharedLibsModule],
  declarations: [AlertComponent, AlertErrorComponent, HasAnyAuthorityDirective],
  exports: [InventorySharedLibsModule, AlertComponent, AlertErrorComponent, HasAnyAuthorityDirective],
})
export class InventorySharedModule {}
