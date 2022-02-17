
const pageNumbers = (total, max, current) => {
  const half = Math.floor(max / 2);
  let to = max;
  
  if(current + half >= total) {
    to = total;
  } else if(current > half) {
    to = current + half ;
  }
  
  let from = to - max;

  return Array.from({length: max}, (_, i) => (i + 1) + from);
}

function PaginationButton(totalPages, maxPagesVisible = 5, currentPage = 1) {
  let pages = pageNumbers(totalPages, maxPagesVisible, currentPage);
  let currentPageBtn = null;
  const buttons = new Map();
  const disabled = {
    start: () => pages[0] === 1,
    prev: () => currentPage === 1,
    end: () => pages.slice(-1)[0] === totalPages,
    next: () => currentPage === totalPages
  }
  const frag = document.createDocumentFragment();
  const paginationButtonContainer = document.createElement('div');
  paginationButtonContainer.className = 'pagination-buttons';
  paginationButtonContainer.id = 'pagination-buttons';
  
  const createAndSetupButton = (label = '', cls = '', disabled = false, handleClick) => {
    const buttonElement = document.createElement('a');
    buttonElement.textContent = label;
    let pageNum = parseInt(label);let isNotNumber = isNaN(pageNum);
	if(!isNotNumber) {
		let path = 'apply?command=show_user_reports&username=' + username + '&page=' + pageNum;
		path = path.replace(' ', '');
		buttonElement.href = path;
	}
    buttonElement.className = `page-btn ${cls}`;
    buttonElement.disabled = disabled;
    buttonElement.addEventListener('click', e => {
      handleClick(e);
      this.update();
      paginationButtonContainer.value = currentPage;
      paginationButtonContainer.dispatchEvent(new Event('change'));
    });
    
    return buttonElement;
  }
  
  const onPageButtonClick = e => currentPage = Number(e.currentTarget.textContent);
  
  const onPageButtonUpdate = index => (btn) => {
    btn.textContent = pages[index];
    
    if(pages[index] === currentPage) {
      currentPageBtn.classList.remove('active');
      btn.classList.add('active');
      currentPageBtn = btn;
      currentPageBtn.focus();
    }
  };
  
  pages.map((pageNumber, index) => {
    const isCurrentPage = currentPage === pageNumber;
    const button = createAndSetupButton(
      pageNumber, isCurrentPage ? 'active' : '', false, onPageButtonClick
    );
    
    if(isCurrentPage) {
      currentPageBtn = button;
    }
    
    buttons.set(button, onPageButtonUpdate(index));
  });
  
  buttons.forEach((_, btn) => frag.appendChild(btn));
  paginationButtonContainer.appendChild(frag);
  
  this.render = (container = document.getElementById('pagination')) => {
    container.appendChild(paginationButtonContainer);
  }
  
  this.update = (newPageNumber = currentPage) => {
    currentPage = newPageNumber;
    pages = pageNumbers(totalPages, maxPagesVisible, currentPage);
    buttons.forEach((updateButton, btn) => updateButton(btn));
  }
  
  this.onChange = (handler) => {
    paginationButtonContainer.addEventListener('change', handler);
  }
}


const paginationButtons = new PaginationButton(pages, pageSelectorCounter);

paginationButtons.render();

var paginationElements = document.getElementsByClassName('page-btn')
var pageNumbersArray = []

for(i = 2; i < paginationElements.length-2; i++) {
	pageNumbersArray.push(paginationElements[i])
}

for(let pageNumberQuery of pageNumbersArray) {
	pageNumberQuery.addEventListener('click', function(){
		showPage(pageNumberQuery);
	});
}

