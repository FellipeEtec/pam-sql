- [adicionar dependencias do Room]
- Classes de Modelagem/Tabela
- Interface Dao
- Database
- Interface do Repositório
- Repositório Offline (injeta o Dao)
- AppContainer (instancia o Repositório)
- Classes de UI State
- [adicionar dependencias do ViewModel]
- ViewModels das Tabelas
- [instanciar a aplicação] (a classe precisa estar definida no Manifest)
- ViewModelProvider
- [instanciar o ViewModel]
- Formulário
- Botão de Salvar

---

[adicionar dependencias do Room]

Classes de Modelagem/Tabela

Interface Dao

Database

Interface do Repositório

Repositório Offline (injeta o Dao)

AppContainer (instancia o Repositório)
	override val itemsRepository: ItemsRepository by lazy {   
		OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
	}

Classes de UI State

[adicionar dependencias do ViewModel]

ViewModels das Tabelas

[instanciar a aplicação] (a classe precisa estar definida no Manifest)
	fun CreationExtras.empresaApplication(): EmpresaApplication =  
	    (this[AndroidViewModelFactory.APPLICATION_KEY] as EmpresaApplication)

ViewModelProvider
	object AppViewModelProvider {    
		val Factory = viewModelFactory {    
			initializer {            
				ItemEntryViewModel(
					inventoryApplication()
					.container
					.itemsRepository)
			}
		}
	}

[instanciar o ViewModel]
	viewModel: ClienteEntryViewModel = 
		viewModel(factory = AppViewModelProvider.Factory)

Formulário

Botão de Salvar
	val coroutineScope = rememberCoroutineScope()
	...
	onClick = { 
		coroutineScope.launch {
			viewModel.saveItem()
		}
	}
