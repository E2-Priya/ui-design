import { fireEvent , render, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import { createStore } from "redux";
import { Provider } from "react-redux";
import { allReducers } from '../../../Reducers';
import App from '../../../App';
import userEvent from '@testing-library/user-event';
import { login } from '../../clothSkeleton/__test__/clothSkeleton.test';
import { obj } from '../../productDetail';
const store = createStore(allReducers);
var products = obj.table
function addPrtBtn(){
    let addpr = screen.getByTestId('addProductBtn')
    fireEvent.click(addpr)
}

describe('add form div', () => {
    test('add form div render', () => {
      render( <Provider store={store}>
        <App/>
      </Provider>
      );
        login()
        addPrtBtn()
        expect(screen.getByTestId('addFormCont')).toBeInTheDocument()
        expect(screen.getByTestId('formAddProduct')).toBeInTheDocument()

        const prIdLabel = screen.getByTestId('prIdLabel')
        const prIdInput = screen.getByTestId('prIdInput')
        expect(prIdLabel).toBeInTheDocument()
        expect(prIdLabel.innerHTML).toEqual('ENTER PRODUCT ID : ')
        expect(prIdInput).toBeInTheDocument()
        expect(prIdInput.innerHTML).toEqual('')
        expect(prIdInput).toBeEnabled()

        const prNameLabel = screen.getByTestId('prNameLabel')
        const prNameInput = screen.getByTestId('prNameInput')
        expect(prNameLabel).toBeInTheDocument()
        expect(prNameLabel.innerHTML).toEqual('ENTER PRODUCT NAME : ')
        expect(prNameInput).toBeInTheDocument()
        expect(prNameInput.innerHTML).toEqual('')
        expect(prNameInput).toBeEnabled()

        const prQuantityLabel = screen.getByTestId('prQuantityLabel')
        const prQuantityInput = screen.getByTestId('prQuantityInput')
        expect(prQuantityLabel).toBeInTheDocument()
        expect(prQuantityLabel.innerHTML).toEqual('ENTER QUANTITY : ')
        expect(prQuantityInput).toBeInTheDocument()
        expect(prQuantityInput.innerHTML).toEqual('')
        expect(prQuantityInput).toBeEnabled()

        const prPriceLabel = screen.getByTestId('prPriceLabel')
        const prPriceInput = screen.getByTestId('prPriceInput')
        expect(prPriceLabel).toBeInTheDocument()
        expect(prPriceLabel.innerHTML).toEqual('ENTER PRODUCT PRICE: ')
        expect(prPriceInput).toBeInTheDocument()
        expect(prPriceInput.innerHTML).toEqual('')
        expect(prPriceInput).toBeEnabled()

        expect(screen.getByTestId('prImgLabel')).toBeInTheDocument()
        expect(screen.getByTestId('prImgLabel').innerHTML).toEqual('UPLOAD PRODUCT IMAGE: ')
        expect(screen.getByTestId('prImgInput')).toBeInTheDocument()
    });

    test('add form with invalid datas', () => {
        render( <Provider store={store}>
          <App/>
        </Provider>
        );

        const prIdInput = screen.getByTestId('prIdInput')
        fireEvent.blur(prIdInput)
        expect(screen.getByTestId('idErr').innerHTML).toEqual('Enter valid product id')

        userEvent.type(prIdInput, "5001");
        expect(screen.getByTestId('idErr').innerHTML).toEqual('')

        const prNameInput = screen.getByTestId('prNameInput')
        fireEvent.blur(prNameInput)
        expect(screen.getByTestId('nameErr').innerHTML).toEqual('Enter valid product name')

        userEvent.type(prNameInput, "name");
        expect(screen.getByTestId('nameErr').innerHTML).toEqual('')

        const prQuantityInput = screen.getByTestId('prQuantityInput')
        fireEvent.blur(prQuantityInput)
        expect(screen.getByTestId('quantityErr').innerHTML).toEqual('Enter valid quantity')

        userEvent.type(prQuantityInput, '45');
        expect(screen.getByTestId('quantityErr').innerHTML).toEqual('')

        const prPriceInput = screen.getByTestId('prPriceInput')
        fireEvent.blur(prPriceInput)
        expect(screen.getByTestId('priceErr').innerHTML).toEqual('Enter valid price')

        userEvent.type(prPriceInput, '699');
        expect(screen.getByTestId('priceErr').innerHTML).toEqual('')
      });

    test('add form with valid datas', () => {
        render( <Provider store={store}>
          <App/>
        </Provider>
        );

        let prIdInput = screen.getByTestId('prIdInput')
        userEvent.type(prIdInput, "5001");

        let prNameInput = screen.getByTestId('prNameInput')
        userEvent.type(prNameInput,'jegging')

        let prQuantityInput = screen.getByTestId('prQuantityInput')
        userEvent.type(prQuantityInput,'56')

        let prPriceInput = screen.getByTestId('prPriceInput')
        userEvent.type(prPriceInput,'699')
        /*
        let prImgInput = screen.getByTestId('prImgInput')
        userEvent.upload(prImgInput , 'C:\Users\e2infoadmin\Downloads\download.jpg')*/

       /* const fileInput = screen.getByTestId('prImgInput');
        const file = new File(['test file content'], 'test.jpg', {
            type: 'jpg/png',
        });
        fireEvent.change(fileInput, { target: { files: [file] } });

        const fileName = screen.getByTestId('prImgInput');
        expect(fileName.textContent).toBe('test.jpg');
      */
        let submitForm = screen.getByTestId('submitForm')
        fireEvent.click(submitForm)

        const boxDiv = screen.getAllByTestId('boxDiv')
        expect(boxDiv.length)
        expect(boxDiv[products.length -1]).toBeInTheDocument()
        expect(screen.getAllByTestId('productNameRender')[products.length -1].innerHTML).toEqual('jegging')

      });



})
