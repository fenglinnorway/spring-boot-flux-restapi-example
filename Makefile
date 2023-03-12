.PHONY: default
default: | help

.PHONY: update-all
update-all: ## Checkout or update all related dapla repos
	./git-update.sh

.PHONY: print-local-changes
print-local-changes: ## Show a brief summary of local changes
	./git-status.sh